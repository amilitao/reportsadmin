package br.com.atacadao.reportsadmin.model;

public enum TipoRelatorio {

	TXT(""), PDF(".pdf"), CSV(".csv");
	
	private final String extensao;
	
	TipoRelatorio(String extensao) {
		this.extensao = extensao;		
	
	
	}

	public String getExtensao() {
		return extensao;
	}

	
	
	
}
