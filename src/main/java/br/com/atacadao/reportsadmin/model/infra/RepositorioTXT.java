package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class RepositorioTXT implements Repositorio{
	
	private String path = PathDiretorioEnum.DIR_TXT.getPath();

	@Override
	public String getPath() {		
		return this.path;
	}

	@Override
	public boolean atualiza(Relatorio relatorio) {
	
		//verifica se existe o arquivo na pasta recebidos
		//o arquivo já deve ter sido renomeado
		//se nao encontrar retorna falso
		
		return false;
		
	}

	@Override
	public void adiciona(File file) {
		
		//move o arquivo do diretorio recebidos para o diretorio TXT
		
	}
	
	

}
