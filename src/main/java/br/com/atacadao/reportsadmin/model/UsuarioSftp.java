package br.com.atacadao.reportsadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UsuarioSftp {
	
	
	@Id
	@NotBlank(message="Este campo não pode ser vazio")
	private String login;

	@NotBlank(message="Este campo não pode ser vazio")
	private String password;
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
