package br.com.atacadao.reportsadmin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_relatorio;
	
	private String nome_relatorio;
	
	

	public Long getId_relatorio() {
		return id_relatorio;
	}

	public void setId_relatorio(Long id_relatorio) {
		this.id_relatorio = id_relatorio;
	}

	public String getNome_relatorio() {
		return nome_relatorio;
	}

	public void setNome_relatorio(String nome_relatorio) {
		this.nome_relatorio = nome_relatorio;
	}

	
	

}
