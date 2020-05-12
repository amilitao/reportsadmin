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
import br.com.atacadao.reportsadmin.model.Funcionario;
import br.com.atacadao.reportsadmin.model.dao.DepartamentoDAO;
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;


@Transactional
@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {	
	
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@RequestMapping("/form")
	public ModelAndView form(Funcionario funcionario) {		
		
		ModelAndView mav = new ModelAndView("funcionario/form");		
		List<Departamento> departamentos = departamentoDAO.list();	
		
		mav.addObject("departamentos", departamentos);	
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {			
			return form(funcionario);
		}

		if(funcionario.getId() == null) {

			funcionarioDAO.save(funcionario);
			redirectAttributes.addFlashAttribute("sucesso", "Funcionario cadastrado com sucesso");
		}else {
		
			Funcionario f = funcionarioDAO.find(funcionario.getId());
					
			f.setNome(funcionario.getNome());
			f.setEmail(funcionario.getEmail());
			f.setDepartamento(funcionario.getDepartamento());
			
						
			redirectAttributes.addFlashAttribute("sucesso", "Funcionario atualizado com sucesso");
		}
		
		return new ModelAndView("redirect:/funcionario");

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("funcionario/list");
		List<Funcionario> funcionarios = funcionarioDAO.list();			
		
		mav.addObject("funcionarios", funcionarios);			
		
		return mav;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") long id_funcionario, 
			RedirectAttributes redirectAttributes) {
		
		ModelAndView mav = new ModelAndView("funcionario/form");
		Funcionario funcionario = funcionarioDAO.find(id_funcionario);
		List<Departamento> departamentos = departamentoDAO.list();			
		
		mav.addObject("departamentos", departamentos);		
		mav.addObject("funcionario", funcionario);	
		
		redirectAttributes.addFlashAttribute("sucesso", "Funcionario removido com sucesso");
		
		return mav;		
	}
	
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") long id_funcionario, 
			RedirectAttributes redirectAttributes) {
		
		Funcionario funcionario = funcionarioDAO.find(id_funcionario);
		funcionarioDAO.remove(funcionario);
		
		redirectAttributes.addFlashAttribute("sucesso", "Funcionario removido com sucesso");
		
		return "redirect:/funcionario";
	}

}
