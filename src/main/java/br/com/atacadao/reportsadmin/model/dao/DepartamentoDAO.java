package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Departamento;



@Repository
public class DepartamentoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Departamento departamento) {
		manager.persist(departamento);
	}

	public void remove(Departamento departamento) {
		manager.remove(departamento);
	}

	public void update(Departamento departamento) {
		manager.merge(departamento);
	}

	public List<Departamento> list() {
		return manager.createQuery("select distinct(d) from Departamento d", Departamento.class).getResultList();
	}
	
	public Departamento find(Long id) {
		return manager.find(Departamento.class, id);
	}

	/*public Departamento find(Integer id) {
		TypedQuery<Departamento> query = manager
				.createQuery("select distinct(d) from Departamento d where d.id=:id", Departamento.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}*/

}
