package br.com.atacadao.reportsadmin.model;

import br.com.atacadao.reportsadmin.model.infra.DiretorioCSV;
import br.com.atacadao.reportsadmin.model.infra.DiretorioPDF;
import br.com.atacadao.reportsadmin.model.infra.DiretorioTXT;
import br.com.atacadao.reportsadmin.model.infra.Repositorio;

public enum TipoRelatorio {

	TXT("", new DiretorioTXT()), PDF(".pdf", new DiretorioPDF()), CSV(".csv", new DiretorioCSV());
	
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
