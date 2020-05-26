package br.com.atacadao.reportsadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	@Id
	private String nome;	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String getAuthority() {	
		return nome;
	}
	
	
	@Override
	public String toString() {		
		return nome;
	}

}
