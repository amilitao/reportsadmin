package br.com.atacadao.reportsadmin.model.jsch;

import br.com.atacadao.reportsadmin.model.Relatorio;

public class Transfer {	
	
	private String login;
	private String password;
	private String pathDestino;	
	private Sftp sftp = new Sftp();
	
	
	public void setLogin(String login) {
		this.login = login;
	}	

	public void setPassword(String password) {
		this.password = password;
	}	

	public void setPathDestino(String pathDestino) {
		this.pathDestino = pathDestino;
	}

	public void buscar(Relatorio relatorio) {
		
		DadosParaTransferencia dados = new DadosParaTransferencia(
				relatorio.getServidor().getHost(),
				relatorio.getNome() + ".f" + relatorio.getServidor().getNumero() ,
				this.pathDestino, 
				this.login,
				this.password);

		sftp.transfere(dados);
		
		
	}

}
