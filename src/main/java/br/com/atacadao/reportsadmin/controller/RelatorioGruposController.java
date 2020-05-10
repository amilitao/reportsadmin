package br.com.atacadao.reportsadmin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atacadao.reportsadmin.model.Grupos;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.dao.GruposDAO;
import br.com.atacadao.reportsadmin.model.dao.RelatorioDAO;


@Transactional
@Controller
@RequestMapping("/relatorio-grupos")
public class RelatorioGruposController {
	
	@Autowired
	private RelatorioDAO relatorioDAO;
	
	@Autowired
	private GruposDAO gruposDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listFuncionarioGrupos() {
		
		ModelAndView modelAndView = new ModelAndView("grupos/relatorio-grupos/list");
		
		modelAndView.addObject("relatorios", relatorioDAO.list());
		
		return modelAndView;
	}
	
	@RequestMapping(value =  "/{id}", name = "show-relatorio-grupos")
	public ModelAndView showFuncionarioGrupos(@PathVariable("id") long id) {
		
		ModelAndView modelAndView = new ModelAndView("grupos/relatorio-grupos/show");
		
		Relatorio relatorio = relatorioDAO.find(id);			
		List<Grupos> grupos = gruposDAO.list();
		
		modelAndView.addObject("relatorio", relatorio);
		modelAndView.addObject("grupos", grupos);		
		
		return modelAndView;
	}
	
	@RequestMapping("/salvar-relatorio-grupos")
	public ModelAndView saveRelatorioGrupos(@RequestParam long id_relatorio, 
			@NotNull @RequestParam(name = "selecionados", required = false)String[] grupos,		
			RedirectAttributes redirectAttributes) {			
		
		Relatorio relatorio = relatorioDAO.find(id_relatorio);
		
		Set<Grupos> novos_grupos = new HashSet<Grupos>();		
		
		if(grupos != null) {
			for(String id_grupo : grupos) {			
				novos_grupos.add(gruposDAO.find(Long.valueOf(id_grupo)));
			}
		}
		
		relatorio.setGrupos(novos_grupos);		
		
	    relatorioDAO.update(relatorio);
		
		redirectAttributes.addFlashAttribute("sucesso", "Grupos atualizado com sucesso");
		return new ModelAndView("redirect:/relatorio-grupos/");
	}


}
