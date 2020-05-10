package br.com.atacadao.reportsadmin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atacadao.reportsadmin.model.Servidor;
import br.com.atacadao.reportsadmin.model.dao.ServidorDAO;


@Transactional
@Controller
@RequestMapping("/servidor")
public class ServidorController {

	@Autowired
	private ServidorDAO servidorDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("servidor/list");
		List<Servidor> servidores = servidorDAO.list();

		modelAndView.addObject("servidores", servidores);

		return modelAndView;

	}

	@RequestMapping("/form")
	public ModelAndView form(Servidor servidor) {
		ModelAndView modelAndView = new ModelAndView("servidor/form");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Servidor servidor, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(servidor);
		}

		if (servidor.getId() == null) {
			servidorDAO.save(servidor);
			redirectAttributes.addFlashAttribute("sucesso", "Servidor cadastrado com sucesso");
		} else {
			servidorDAO.update(servidor);
			redirectAttributes.addFlashAttribute("sucesso", "Servidor atualizado com sucesso");
		}
		
		return new ModelAndView("redirect:/servidor");
	}
	

	@RequestMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("servidor/form");
		Servidor servidor = servidorDAO.find(id);

		mav.addObject("servidor", servidor);

		redirectAttributes.addFlashAttribute("sucesso", "Servidor atualizado com sucesso");

		return mav;
	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		Servidor servidor = servidorDAO.find(id);
		servidorDAO.remove(servidor);

		redirectAttributes.addFlashAttribute("sucesso", "Servidor removido com sucesso");

		return "redirect:/servidor";
	}

}
