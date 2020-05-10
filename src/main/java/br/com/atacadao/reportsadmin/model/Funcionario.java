package br.com.atacadao.reportsadmin.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Este campo n�o pode ser vazio")
	private String nome;
	
	@Email(message="Email com formato incorreto")
	@NotBlank(message="Este campo n�o pode ser vazio")
	private String email;

	@ManyToOne
	private Departamento departamento;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "agenda", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "relatorio_id"))
	private Set<Relatorio> relatorios;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionario_grupos", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "grupos_id"))	
	private Set<Grupos> grupos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(Set<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	public Set<Grupos> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupos> grupos) {
		this.grupos = grupos;
	}
	
public Set<Relatorio> getRelatoriosPermitidos(){
		
		Set<Relatorio> permitidos = new HashSet<>();
		
		if (!this.getGrupos().isEmpty()) {

			for (Grupos grupos : this.getGrupos()) {

				if (!grupos.getRelatorios().isEmpty()) {

					for (Relatorio relatorio : grupos.getRelatorios()) {
						permitidos.add(relatorio);
					}
				}
			}
		}
		
		return permitidos;
		
	}
	
	

}
