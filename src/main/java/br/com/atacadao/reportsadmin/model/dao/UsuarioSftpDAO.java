package br.com.atacadao.reportsadmin.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.UsuarioSftp;

@Repository
public class UsuarioSftpDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(UsuarioSftp usuario) {
		em.persist(usuario);
	}
	
	
	public void update(UsuarioSftp usuario) {
		em.merge(usuario);
	}
	
	public UsuarioSftp getUsuarioSftp() {
		return em.createQuery("select distinct(u) from UsuarioSftp u",
				UsuarioSftp.class).getSingleResult();
	}

}
