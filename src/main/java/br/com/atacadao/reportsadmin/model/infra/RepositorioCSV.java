package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;

public class RepositorioCSV implements Repositorio{
	
	private String path = PathDiretorioEnum.DIR_CSV.getPath();

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void adiciona(File file, String novoNome) {
		
		file.renameTo(new File(path + novoNome + TipoRelatorio.CSV.getExtensao()));
		
	}

	@Override
	public boolean ehDisponivel(Relatorio relatorio) {
		
		File file = new File(path + relatorio.getNomeArquivo());	
		
		return file.exists();
	}

	
}
