package br.com.atacadao.reportsadmin.model;

import java.io.File;

public class ApagadorDeRelatorio {


	public void excluiArquivosDe(PathDiretorioEnum dir) {

		File diretorio = new File(dir.getPath());

		for (File file : diretorio.listFiles()) {
			if (file.isFile()) {
				file.delete();				
			}
		}
	
	}

}
