package br.com.atacadao.reportsadmin.controller;

import java.util.Calendar;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atacadao.reportsadmin.model.Funcionario;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.StatusRelatorio;
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;
import br.com.atacadao.reportsadmin.model.dao.RelatorioDAO;
import br.com.atacadao.reportsadmin.model.infra.GerenciadorDeArquivos;
import br.com.atacadao.reportsadmin.model.mail.Correio;
import br.com.atacadao.reportsadmin.model.mail.Email;

@Transactional
@Controller
@RequestMapping("/envio-de-relatorio")
public class EnvioRelatorioController {

	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@Autowired
	private RelatorioDAO relatorioDAO;
	
	@Autowired
	private Correio correio;
	
	@Autowired
	private GerenciadorDeArquivos gerenciadorDeArquivos;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("envioderelatorio/list");
		modelAndView.addObject("funcionarios", funcionarioDAO.list());

		return modelAndView;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {

		ModelAndView modelAndView = new ModelAndView("envioderelatorio/show");
		Funcionario funcionario = funcionarioDAO.find(id);

		modelAndView.addObject("funcionario", funcionario);
		modelAndView.addObject("relatoriosPermitidos", funcionario.listaDeRelatoriosPermitidos());

		return modelAndView;
	}

	@RequestMapping("atualiza/rel/{id_relatorio}/func/{id_funcionario}")
	public ModelAndView download(@PathVariable("id_relatorio") Long id_relatorio,
			@PathVariable("id_funcionario") Long id_funcionario, RedirectAttributes redirectAttributes) {
			
		Relatorio relatorio = relatorioDAO.find(id_relatorio);		
			
		if(gerenciadorDeArquivos.atualiza(relatorio)) {
			
			relatorio.setStatus(StatusRelatorio.DISPONIVEL);
			relatorio.setDtAtualizacao(Calendar.getInstance());			
			
		}else {
			
			relatorio.setStatus(StatusRelatorio.INDISPONIVEL);
			
		}			
		
		return new ModelAndView("redirect:/envio-de-relatorio/" + id_funcionario);
	}

	@RequestMapping("/enviar")
	public ModelAndView enviarEmail(@RequestParam Long idFuncionario,
			@RequestParam(name = "selecionados", required = false) String[] selecionados,
			RedirectAttributes redirectAttributes) {
		
		/*
		 * Set<Relatorio> relatoriosSelecionados = new HashSet<>();
		 * 
		 * if (relatoriosSelecionados != null) {
		 * 
		 * for (String idRelatorio : selecionados) {
		 * relatoriosSelecionados.add(relatorioDAO.find(Long.valueOf(idRelatorio))); }
		 * 
		 * }
		 */		
		
		Funcionario funcionario = funcionarioDAO.find(idFuncionario);
		
		Set<Relatorio> relatoriosSelecionados = funcionario.filtraRelatoriosSelecionados(selecionados);
		
		for(Relatorio relatorio : relatoriosSelecionados) {		
			correio.envia(new Email(funcionario, relatorio));
		}				

		return new ModelAndView("redirect:/envio-de-relatorio/" + idFuncionario);

	}

	@RequestMapping("viewPDF/id/{id_relatorio}")
	public void viewPDF(@PathVariable("id_relatorio") long id_relatorio, HttpServletResponse response) {

	}
	

}
