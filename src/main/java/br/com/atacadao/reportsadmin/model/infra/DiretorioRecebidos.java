package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;

public class DiretorioRecebidos {
	private String path;
	private File[] recebidos;
	private PadronizadorDeNomeDeRelatorio padronizador;
	
	
	
	public File[] getRecebidos() {
		return recebidos;
	}
	

	public DiretorioRecebidos() {
		path = PathDiretorioEnum.DIR_RECEBIDOS.getPath();
		recebidos = new File(path).listFiles();
		padronizador = new PadronizadorDeNomeDeRelatorio();
	}

	public void renomearArquivos() {		
		//lista os arquivos recebidos e padroniza o nome
		
		TipoRelatorio tipo;
		
		for(File file : recebidos) {
			tipo = padronizador.identificaTipo(file);
			tipo.getRepositorio().adiciona(file);
			
			//padronizador.executa(file);
		}
		
	}

}
