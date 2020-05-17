package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.Relatorio;

public interface Repositorio {
	
	String getPath();

	boolean atualiza(Relatorio relatorio);

	void adiciona(File file,  String novoNome);

}
