package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Funcionario;

@Repository
public class FuncionarioDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Funcionario funcionario) {
		manager.persist(funcionario);
	}

	public Funcionario find(Long id) {
		return manager.find(Funcionario.class, id);
	}

	public void remove(Funcionario funcionario) {
		manager.remove(funcionario);
	}

	public void update(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	public List<Funcionario> list() {
		return manager.createQuery("select distinct(f) from Funcionario f order by nome" 
				, Funcionario.class).getResultList();
	}

}
