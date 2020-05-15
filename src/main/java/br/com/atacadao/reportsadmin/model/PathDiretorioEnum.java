package br.com.atacadao.reportsadmin.model;

import java.io.File;

public enum PathDiretorioEnum {

	DIR_BASE("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator),
	
	DIR_RECEBIDOS("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos"
			+ File.separator + "reportsadmin" + File.separator + "recebidos" + File.separator),
	
	DIR_PDF("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "repositorio" + File.separator + "pdf" + File.separator),
	
	DIR_CSV("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "repositorio" + File.separator + "csv" + File.separator),
	
	DIR_TXT("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "repositorio" + File.separator + "txt" + File.separator),
	
	DIR_LOG("c:" + File.separator + "home" + File.separator + "usuario" + File.separator + "projetos" + File.separator
			+ "reportsadmin" + File.separator + "log" + File.separator);

	/*
	 * DIR_BASE("/home/usuario/projetos/reportsadmin"),
	 * DIR_RECEBIDOS("/home/usuario/projetos/reportsadmin/recebidos"),
	 * DIR_PDF("/home/usuario/projetos/reportsadmin/repositorio/pdf"),
	 * DIR_CSV("/home/usuario/projetos/reportsadmin/repositorio/csv"),
	 * DIR_TXT("/home/usuario/projetos/reportsadmin/repositorio/txt"),
	 * DIR_LOG("/home/usuario/projetos/reportsadmin/log");
	 */

	private final String path;

	PathDiretorioEnum(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
