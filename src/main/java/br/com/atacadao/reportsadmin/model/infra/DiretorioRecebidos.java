package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;

public class DiretorioRecebidos {
	
	private static File[] recebidos;
	private static PadronizadorDeNomeDeRelatorio padronizador;
	
	public DiretorioRecebidos() {
		recebidos = new File(PathDiretorioEnum.DIR_RECEBIDOS.getPath()).listFiles();
		padronizador = new PadronizadorDeNomeDeRelatorio();
	}

	public static void renomearArquivos() {		
		//lista os arquivos recebidos e padroniza o nome
		
		for(File file : recebidos) {
			padronizador.executa(file);
		}
		
	}

}
