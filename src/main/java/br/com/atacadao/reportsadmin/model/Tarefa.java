package br.com.atacadao.reportsadmin.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarefa;
	
	private String nome;
	
	private String descricao;
	
	private String horario;
	
	private boolean ligado;
	
	@DateTimeFormat(iso = ISO.DATE)
	private Calendar dt_ultima_execucao;
	
	
	public Long getId_tarefa() {
		return id_tarefa;
	}

	public void setId_tarefa(Long id_tarefa) {
		this.id_tarefa = id_tarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public Calendar getDt_ultima_execucao() {
		return dt_ultima_execucao;
	}

	public void setDt_ultima_execucao(Calendar dt_ultima_execucao) {
		this.dt_ultima_execucao = dt_ultima_execucao;
	}

	
	
	
	
}
