package br.com.atacadao.reportsadmin.model.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.jsch.Transfer;

@Component
public class GerenciadorDeArquivos {
	
	@Autowired
	private Transfer transfer;
	

	public void atualiza(Relatorio relatorio) {
		
		try {
			transfer.transfere(relatorio);
		} catch (Exception ex) {	
			//gravar mensagem no log
			System.out.println(ex.getMessage());
		}
		
		
		
	}

}
