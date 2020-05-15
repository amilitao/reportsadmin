package br.com.atacadao.reportsadmin.model;

import br.com.atacadao.reportsadmin.model.infra.Diretorio;
import br.com.atacadao.reportsadmin.model.infra.DiretorioCSV;
import br.com.atacadao.reportsadmin.model.infra.DiretorioPDF;
import br.com.atacadao.reportsadmin.model.infra.DiretorioTXT;

public enum TipoRelatorio {

	TXT("", new DiretorioTXT()), PDF(".pdf", new DiretorioPDF()), CSV(".csv", new DiretorioCSV());
	
	private final String extensao;
	private final Diretorio diretorio;
	
	TipoRelatorio(String extensao, Diretorio diretorio) {
		this.extensao = extensao;		
		this.diretorio = diretorio;
	
	}

	public String getExtensao() {
		return extensao;
	}

	public Diretorio getDiretorio() {
		return diretorio;
	}	

	
	
}
