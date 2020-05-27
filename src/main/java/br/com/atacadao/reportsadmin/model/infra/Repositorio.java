package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.Relatorio;

public interface Repositorio {
	
	String getPath();	

	void adiciona(File file,  String novoNome);
	
	void excluiAntigo(String novoNome);

	boolean ehDisponivel(Relatorio relatorio);

}
