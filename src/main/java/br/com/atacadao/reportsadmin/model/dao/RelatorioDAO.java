package br.com.atacadao.reportsadmin.model.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Relatorio;


@Repository
public class RelatorioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Relatorio relatorio) {
		manager.persist(relatorio);
	}
	
	public void update(Relatorio relatorio) {
		manager.merge(relatorio);
	}
	
	public void remove(Relatorio relatorio) {
		manager.remove(relatorio);
	}

	public List<Relatorio> list() {
		return manager.createQuery("select distinct(r) from Relatorio r" ,
				Relatorio.class).getResultList();
	}
	
	public Relatorio find(Long id) {		
		return manager.find(Relatorio.class, id);
	}
	
}
