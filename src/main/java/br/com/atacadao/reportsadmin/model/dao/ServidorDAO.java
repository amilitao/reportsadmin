package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Servidor;


@Repository
public class ServidorDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Servidor servidor){
		manager.persist(servidor);
	}
	
	public void update(Servidor servidor) {
		manager.merge(servidor);
	}
	
	public void remove(Servidor servidor) {
		manager.remove(servidor);
	}
	
	public Servidor find(Long id) {
		return manager.find(Servidor.class, id);
	}

	public List<Servidor> list() {
		return manager.createQuery("select distinct(s) from Servidor s",
				Servidor.class).getResultList();
	}
	
	public List<Servidor> listByHost(String host){
		return manager.createQuery("select distinct(s) from Servidor s where s.host = :host ",
				Servidor.class).setParameter("host", host ).getResultList();
	}

}
