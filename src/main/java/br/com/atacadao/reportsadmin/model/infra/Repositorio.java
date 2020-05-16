package br.com.atacadao.reportsadmin.model.infra;

import br.com.atacadao.reportsadmin.model.Relatorio;

public interface Repositorio {
	
	String getPath();

	boolean atualiza(Relatorio relatorio);

}
