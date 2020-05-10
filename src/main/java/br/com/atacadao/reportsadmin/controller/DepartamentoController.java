package br.com.atacadao.reportsadmin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atacadao.reportsadmin.model.Departamento;
import br.com.atacadao.reportsadmin.model.dao.DepartamentoDAO;


@Transactional
@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO departamentoDAO;

	@GetMapping("/form")
	public ModelAndView form(Departamento departamento) {
		ModelAndView modelAndView = new ModelAndView("departamento/form");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Departamento departamento, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(departamento);
		}

		if (departamento.getId() == null) {
			departamentoDAO.save(departamento);
			redirectAttributes.addFlashAttribute("sucesso", "Departamento cadastrado com sucesso");
		} else {
			departamentoDAO.update(departamento);
			redirectAttributes.addFlashAttribute("sucesso", "Departamento atualizado com sucesso");
		}
		
		return new ModelAndView("redirect:/departamento");

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("departamento/list");
		List<Departamento> listaDeDepartamentos = departamentoDAO.list();

		modelAndView.addObject("departamentos", listaDeDepartamentos);

		return modelAndView;
	}

	@RequestMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("departamento/form");
		Departamento departamento = departamentoDAO.find(id);

		mav.addObject("departamento", departamento);

		redirectAttributes.addFlashAttribute("sucesso", "Departamento atualizado com sucesso");

		return mav;
	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		Departamento departamento = departamentoDAO.find(id);
		departamentoDAO.remove(departamento);

		redirectAttributes.addFlashAttribute("sucesso", "Departamento removido com sucesso");

		return "redirect:/departamento";
	}

}