package br.com.atacadao.reportsadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.atacadao.reportsadmin.model.Funcionario;
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
		modelAndView.addObject("permitidos", funcionario.getRelatoriosPermitidos());

		return modelAndView;
	}

}
