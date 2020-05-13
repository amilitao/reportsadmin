package br.com.atacadao.reportsadmin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;
import br.com.atacadao.reportsadmin.model.dao.RelatorioDAO;


@Transactional
@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private RelatorioDAO relatorioDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("agendamento/list");

		List<Funcionario> funcionarios = funcionarioDAO.list();

		modelAndView.addObject("funcionarios", funcionarios);

		return modelAndView;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("agendamento/show");

		Funcionario funcionario = funcionarioDAO.find(id);	

		modelAndView.addObject("funcionario", funcionario);
		modelAndView.addObject("relatoriosPermitidos", funcionario.listaDeRelatoriosPermitidos());

		return modelAndView;
	}

	@RequestMapping("/salvar-agendamento")
	public ModelAndView salvar(@RequestParam long id,
			@RequestParam(name = "selecionados", required = false) String[] selecionados,
			RedirectAttributes redirectAttributes) {

		Funcionario funcionario = funcionarioDAO.find(id);
		Set<Relatorio> relatoriosAgendados = new HashSet<>();

		if (selecionados != null) {			

			for (String rel : selecionados) {
				relatoriosAgendados.add(relatorioDAO.find(Long.valueOf(rel)));
			}			

		}
		
		funcionario.setRelatorios(relatoriosAgendados);		
		funcionarioDAO.update(funcionario);
		
		redirectAttributes.addFlashAttribute("sucesso", "Relatórios agendados atualizados com sucesso!");

		return new ModelAndView("redirect:/agendamento/" + funcionario.getId());

	}	
	

	
}
