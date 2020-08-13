package br.com.atacadao.reportsadmin.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.atacadao.reportsadmin.model.CredencialSftp;

@Repository
public class CredencialSftpDAO {
	

	@PersistenceContext
	private EntityManager manager;
	
	public void save(CredencialSftp credencial) {
		manager.persist(credencial);
	}
	
	public void update(CredencialSftp credencial) {
		manager.merge(credencial);
	}
	
	public CredencialSftp find(Long id) {		
		return manager.find(CredencialSftp.class, id);
	}

}
