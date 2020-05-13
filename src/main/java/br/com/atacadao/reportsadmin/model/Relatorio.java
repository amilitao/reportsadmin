package br.com.atacadao.reportsadmin.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToOne
	private Servidor servidor;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoRelatorio tipoRelatorio;
	
	@ManyToMany(mappedBy = "relatorios")
	private Set<Funcionario> funcionarios;

	@ManyToMany
	@JoinTable(name = "relatorio_grupos", joinColumns = @JoinColumn(name = "relatorio_id"), inverseJoinColumns = @JoinColumn(name = "grupos_id"))
	private Set<Grupos> grupos;
	
	@Enumerated(EnumType.STRING)
	public StatusRelatorio status = StatusRelatorio.INDISPONIVEL;

	@DateTimeFormat(iso = ISO.DATE)
	private Calendar dtAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
		

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Set<Grupos> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupos> grupos) {
		this.grupos = grupos;
	}

	public TipoRelatorio getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(TipoRelatorio tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public StatusRelatorio getStatus() {
		return status;
	}

	public void setStatus(StatusRelatorio status) {
		this.status = status;
	}

	public Calendar getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Calendar dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

		
	
	

}
