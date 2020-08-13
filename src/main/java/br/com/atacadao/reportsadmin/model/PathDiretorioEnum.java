package br.com.atacadao.reportsadmin.model;

import java.io.File;

public enum PathDiretorioEnum {

	DIR_BASE("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator),
	
	DIR_RECEBIDOS("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos"
			+ File.separator + "reportsadmin" + File.separator + "recebidos" + File.separator),
	
	DIR_ENVIAR("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos"
			+ File.separator + "reportsadmin" + File.separator + "enviar" + File.separator),
	
	DIR_REPOSITORIO("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "repositorio" + File.separator),
	
	DIR_TEMP("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos"
			+ File.separator + "reportsadmin" + File.separator + "temp" + File.separator),
		
	DIR_LOG("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "log" + File.separator);

	/*
	 * DIR_BASE("/home/usuario/projetos/reportsadmin/"),
	 * DIR_RECEBIDOS("/home/usuario/projetos/reportsadmin/recebidos/"),
	 * DIR_ENVIAR("/home/usuario/projetos/reportsadmin/enviar/"),
	 * DIR_REPOSITORIO("/home/usuario/projetos/reportsadmin/repositorio/"),
	 * DIR_TEMP("/home/usuario/projetos/reportsadmin/temp/"),
	 * DIR_LOG("/home/usuario/projetos/reportsadmin/log/");
	 */

	private final String path;

	PathDiretorioEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
