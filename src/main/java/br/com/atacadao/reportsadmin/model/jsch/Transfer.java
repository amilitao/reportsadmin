package br.com.atacadao.reportsadmin.model.jsch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class Transfer {

	private static final Logger log = LoggerFactory.getLogger(Transfer.class);
	
	private String login;
	private String password;
	private String pathDestino = PathDiretorioEnum.DIR_RECEBIDOS.getPath();
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

	public void recebe(Relatorio relatorio){		
		
		String arquivoProcurado = relatorio.getNome() + ".f" + relatorio.getServidor().getNumero();

		DadosParaTransferencia dados = new DadosParaTransferencia(
				relatorio.getServidor().getHost(),
				relatorio.getServidor().getCaminhoBk() + arquivoProcurado, 
				this.pathDestino, 
				this.login,
				this.password);				
	
		try {			
			
			log.info("Buscando arquivo {} no servidor {}", arquivoProcurado, dados.getHost());
			
			sftp.transfere(dados);
			
			log.info("Arquivos encontrados e copiados");
			
		} catch (Exception e) {
			log.error("Erro na transferencia de arquivo: " + e.getMessage());
		}
		
		

	}

}
