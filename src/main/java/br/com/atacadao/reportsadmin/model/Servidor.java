package br.com.atacadao.reportsadmin.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Este campo não pode ser vazio")
	private String numero;
	
	@NotBlank(message="Este campo não pode ser vazio")
	private String host;
	
	@NotBlank(message="Este campo não pode ser vazio")
	private String caminhoBk;

	@OneToMany(mappedBy = "servidor")
	private List<Relatorio> relatorios;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	

	public String getCaminhoBk() {
		return caminhoBk;
	}

	public void setCaminhoBk(String caminhoBk) {
		this.caminhoBk = caminhoBk;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
	

	@Override
	public String toString() {
		return this.numero + " - " + this.host;
	}

	
	

}
