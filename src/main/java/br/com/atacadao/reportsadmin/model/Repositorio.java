package br.com.atacadao.reportsadmin.model;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class Repositorio {

	public boolean existe(Relatorio relatorio) {
		
		File arquivo = new File(PathDiretorioEnum.DIR_REPOSITORIO + relatorio.getNomeArquivo());		
		return arquivo.exists();
	}

	public File get(Relatorio relatorio) {
		
		if(this.existe(relatorio)) {
			return new File(PathDiretorioEnum.DIR_REPOSITORIO + relatorio.getNomeArquivo());
		}
		
		return null;
	}
	
	public void apagaRelatorios() {
		ApagadorDeRelatorio excluidor = new ApagadorDeRelatorio();		
		excluidor.excluiArquivosDe(PathDiretorioEnum.DIR_REPOSITORIO);		
		
	}

}
