package br.com.atacadao.reportsadmin.model;

import br.com.atacadao.reportsadmin.model.infra.RepositorioCSV;
import br.com.atacadao.reportsadmin.model.infra.RepositorioPDF;
import br.com.atacadao.reportsadmin.model.infra.RepositorioTXT;
import br.com.atacadao.reportsadmin.model.infra.Repositorio;

public enum TipoRelatorio {

	TXT("", new RepositorioTXT()), PDF(".pdf", new RepositorioPDF()), CSV(".csv", new RepositorioCSV());
	
	private final String extensao;
	private final Repositorio repositorio;
	
	TipoRelatorio(String extensao, Repositorio repositorio) {
		this.extensao = extensao;		
		this.repositorio = repositorio;
	
	}

	public String getExtensao() {
		return extensao;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}	

	
	
}
