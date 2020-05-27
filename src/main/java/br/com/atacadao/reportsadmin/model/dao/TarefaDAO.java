package br.com.atacadao.reportsadmin.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.Tarefa;

@Repository
public class TarefaDAO {


	@PersistenceContext
	private EntityManager manager;

	public void save(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	public Tarefa find(Long id) {
		return manager.find(Tarefa.class, id);
	}
	
	public Tarefa findByNome(String nome) {
		return manager.createQuery("select distinct(t) from Tarefa t where t.nome = :nome ",
				Tarefa.class).setParameter("nome", nome ).getSingleResult();
	}

	public void remove(Tarefa tarefa) {
		manager.remove(tarefa);
	}

	public void update(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public List<Tarefa> list() {
		return manager.createQuery("select distinct(t) from Tarefa t",
				Tarefa.class).getResultList();
	}
	
}
