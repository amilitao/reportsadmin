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

import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.Servidor;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;
import br.com.atacadao.reportsadmin.model.dao.RelatorioDAO;
import br.com.atacadao.reportsadmin.model.dao.ServidorDAO;

@Transactional
@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioDAO relatorioDAO;

	@Autowired
	private ServidorDAO servidorDAO;

	@RequestMapping("/form")
	public ModelAndView form(Relatorio relatorio) {
		ModelAndView modelAndView = new ModelAndView("relatorio/form");

		modelAndView.addObject("servidores", servidorDAO.list());
		modelAndView.addObject("tipo", TipoRelatorio.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Relatorio relatorio, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(relatorio);
		}

		if (relatorio.getId() == null) {
			
			relatorioDAO.save(relatorio);
			redirectAttributes.addFlashAttribute("sucesso", "Relatorio cadastrado com sucesso");
		} else {	
			
			Relatorio r = relatorioDAO.find(relatorio.getId());
			
			r.setNome(relatorio.getNome());
			r.setServidor(relatorio.getServidor());
			r.setDescricao(relatorio.getDescricao());		
			r.setTipoRelatorio(relatorio.getTipoRelatorio());			
		
			redirectAttributes.addFlashAttribute("sucesso", "Relatorio atualizado com sucesso");
		}
		
		return new ModelAndView("redirect:/relatorio");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("relatorio/list");

		List<Relatorio> relatorios = relatorioDAO.list();

		modelAndView.addObject("relatorios", relatorios);

		return modelAndView;

	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView update(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("relatorio/form");
		Relatorio relatorio = relatorioDAO.find(id);
		List<Servidor> servidores = servidorDAO.list();

		mav.addObject("servidores", servidores);
		mav.addObject("relatorio", relatorio);

		redirectAttributes.addFlashAttribute("sucesso", "Relatorio atualizado com sucesso");

		return mav;
	}

}
