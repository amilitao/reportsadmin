package br.com.atacadao.reportsadmin.controller;

import java.util.HashSet;
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
import br.com.atacadao.reportsadmin.model.Grupos;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;

@Transactional
@Controller
@RequestMapping("/envio-de-relatorio")
public class EnvioRelatorioController {

	@Autowired
	private FuncionarioDAO funcionarioDAO;


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
		modelAndView.addObject("permitidos", listaDeRelatoriosPermitidos(funcionario.getGrupos()));

		return modelAndView;
	}

	@RequestMapping("atualiza/rel/{id_relatorio}/func/{id_funcionario}")
	public ModelAndView download(@PathVariable("id_relatorio") Long id_relatorio,
			@PathVariable("id_funcionario") Long id_funcionario, RedirectAttributes redirectAttributes) {

		return new ModelAndView("redirect:/envio-de-relatorio/" + id_funcionario);
	}

	@RequestMapping("/enviar")
	public ModelAndView enviarEmail(@RequestParam long id_funcionario,
			@RequestParam(name = "selecionados", required = false) String[] selecionados,
			RedirectAttributes redirectAttributes) {

		return new ModelAndView("redirect:/envio-de-relatorio/" + id_funcionario);

	}

	@RequestMapping("viewPDF/id/{id_relatorio}")
	public void viewPDF(@PathVariable("id_relatorio") long id_relatorio, HttpServletResponse response) {

	}

	public Set<Relatorio> listaDeRelatoriosPermitidos(Set<Grupos> lista) {

		Set<Relatorio> permitidos = new HashSet<>();
		if (!lista.isEmpty()) {
			for (Grupos grupos : lista) {
				if (!grupos.getRelatorios().isEmpty()) {
					for (Relatorio relatorio : grupos.getRelatorios()) {
						permitidos.add(relatorio);
					}
				}
			}
		}
		return permitidos;

	}

}
