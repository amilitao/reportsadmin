package br.com.atacadao.reportsadmin.model.infra;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;

public class DiretorioTXT implements Diretorio{
	
	private String path = PathDiretorioEnum.DIR_TXT.getPath();

	@Override
	public String getPath() {		
		return this.path;
	}

}
