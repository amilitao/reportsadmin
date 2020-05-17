package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class RepositorioPDF implements Repositorio{
	
	private String path = PathDiretorioEnum.DIR_PDF.getPath();

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualiza(Relatorio relatorio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void adiciona(File file, String novoNome) {
		
		file.renameTo(new File(PathDiretorioEnum.DIR_TXT + novoNome));	
		
		file.deleteOnExit();		
	}

	

}
