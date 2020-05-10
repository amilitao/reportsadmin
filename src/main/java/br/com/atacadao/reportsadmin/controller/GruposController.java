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

import br.com.atacadao.reportsadmin.model.Departamento;
import br.com.atacadao.reportsadmin.model.Grupos;
import br.com.atacadao.reportsadmin.model.dao.DepartamentoDAO;
import br.com.atacadao.reportsadmin.model.dao.GruposDAO;


@Transactional
@Controller
@RequestMapping("/grupos")
public class GruposController {

	@Autowired
	private GruposDAO gruposDAO;

	@Autowired
	private DepartamentoDAO departamentoDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("grupos/list");

		modelAndView.addObject("grupos", gruposDAO.list());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Grupos grupo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(grupo);
		}

		if (grupo.getId() == null) {
			gruposDAO.save(grupo);
			redirectAttributes.addFlashAttribute("sucesso", "Grupo cadastrado com sucesso");
		} else {
			gruposDAO.update(grupo);
			redirectAttributes.addFlashAttribute("sucesso", "Grupo atualizado com sucesso");
		}		
		
		return new ModelAndView("redirect:/grupos");
	}

	@RequestMapping("/form")
	public ModelAndView form(Grupos grupo) {
		ModelAndView modelAndView = new ModelAndView("grupos/form");

		modelAndView.addObject("departamentos", departamentoDAO.list());

		return modelAndView;

	}

	@RequestMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("grupos/form");
		Grupos grupos = gruposDAO.find(id);
		List<Departamento> departamentos = departamentoDAO.list();

		mav.addObject("grupos", grupos);
		mav.addObject("departamentos", departamentos);	

		redirectAttributes.addFlashAttribute("sucesso", "Grupos atualizado com sucesso");

		return mav;
	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		Grupos grupos = gruposDAO.find(id);
		gruposDAO.remove(grupos);

		redirectAttributes.addFlashAttribute("sucesso", "Grupos removido com sucesso");

		return "redirect:/grupos";
	}

}
