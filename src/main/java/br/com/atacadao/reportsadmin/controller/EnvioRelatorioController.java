package br.com.atacadao.reportsadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;


@Controller
public class EnvioRelatorioController {
	
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("envioderelatorio/list");
		modelAndView.addObject("funcionarios", funcionarioDAO.list());

		return modelAndView;
	}

}
