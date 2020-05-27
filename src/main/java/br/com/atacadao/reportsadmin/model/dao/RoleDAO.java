package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Role;

@Repository
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Role role){
		manager.persist(role);
	}
	
	public void update(Role role) {
		manager.merge(role);
	}
	
	public void remove(Role role) {
		manager.remove(role);
	}
	
	public Role find(Long id) {
		return manager.find(Role.class, id);
	}

	public List<Role> list() {
		return manager.createQuery("select distinct(r) from Role r",
				Role.class).getResultList();
	}
	
	public Role findByNome(String nome) {
		return manager.createQuery("select distinct(r) from Role r where r.nome = :nome ",
				Role.class).setParameter("nome", nome ).getSingleResult();
	}
	

}
