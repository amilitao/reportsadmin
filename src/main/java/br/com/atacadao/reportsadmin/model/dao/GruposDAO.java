package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Grupos;


@Repository
public class GruposDAO {	
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Grupos grupo) {
		manager.persist(grupo);
	}
	
	public void remove(Grupos grupos) {
		manager.remove(grupos);
	}

	public void update(Grupos grupos) {
		manager.merge(grupos);
	}
	
	public Grupos find(Long id) {
		return manager.find(Grupos.class, id);
	}
	
	public List<Grupos> list() {
		return manager.createQuery("select distinct(g) from Grupos g",
				Grupos.class).getResultList();
	}
	
	public List<Grupos> listByIdDepartamento(long id){
		return manager.createQuery("select distinct(g) from Grupos g where g.departamento.id = :id ",
				Grupos.class).setParameter("id", id ).getResultList();
	}

}
