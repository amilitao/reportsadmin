package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

public class DiretorioTXT implements Diretorio{
	
	private String path = "c:" + File.separator + "home" + File.separator + "usuario" + File.separator
			+ "projetos" + File.separator + "reportsadmin" + File.separator + "repositorio" 
			+ File.separator + "txt" + File.separator;

	@Override
	public String getPath() {		
		return this.path;
	}

}
