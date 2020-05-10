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
import br.com.atacadao.reportsadmin.model.Grupos;
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;
import br.com.atacadao.reportsadmin.model.dao.GruposDAO;



@Transactional
@Controller
@RequestMapping("/funcionario-grupos")
public class FuncionarioGruposController {

	@Autowired
	private GruposDAO gruposDAO;

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listFuncionarioGrupos() {

		ModelAndView modelAndView = new ModelAndView("grupos/funcionario-grupos/list");

		modelAndView.addObject("funcionarios", funcionarioDAO.list());

		return modelAndView;
	}

	@RequestMapping(value = "/{id}", name = "show-funcionario-grupos")
	public ModelAndView showFuncionarioGrupos(@PathVariable("id") long id) {

		ModelAndView modelAndView = new ModelAndView("grupos/funcionario-grupos/show");

		Funcionario funcionario = funcionarioDAO.find(id);
		List<Grupos> gruposLiberados = gruposDAO.listByIdDepartamento(funcionario.getDepartamento().getId());

		modelAndView.addObject("funcionario", funcionario);
		modelAndView.addObject("gruposLiberados", gruposLiberados);

		return modelAndView;
	}

	@RequestMapping("/salvar-funcionario-grupos")
	public ModelAndView saveFuncionarioGrupos(@RequestParam long id, 
			@RequestParam(name = "selecionados", required = false)String[] grupos,		
			RedirectAttributes redirectAttributes) {		
		
		Funcionario funcionario = funcionarioDAO.find(id);
		
		Set<Grupos> novos_grupos = new HashSet<>();
		
		if(grupos != null){
			for(String id_grupo : grupos) {			
				novos_grupos.add(gruposDAO.find(Long.valueOf(id_grupo)));
			}
		}
		
		funcionario.setGrupos(novos_grupos);		
		
	    funcionarioDAO.update(funcionario);
		
		redirectAttributes.addFlashAttribute("sucesso", "Grupos atualizado com sucesso");
		return new ModelAndView("redirect:/funcionario-grupos/");
	}

}
