package br.com.atacadao.reportsadmin.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atacadao.reportsadmin.model.dao.CredencialSftpDAO;

@Service
@Transactional
public class AtualizadorDeRelatorio {
	
	private String diretorioRecebidos = PathDiretorioEnum.DIR_RECEBIDOS.getPath();	
	
	@Autowired
	private CredencialSftpDAO credencialDAO;	

	public void atualiza(Relatorio relatorio) {	
		
		CredencialSftp credencial = credencialDAO.find(1L);
		TransferidorDeArquivos transferidor = new TransferidorDeArquivos(credencial);		
		String host = relatorio.getServidor().getHost();
		String absoluteRemoteFile = relatorio.getAbsoluteRemotePath() + relatorio.getNome() + "*";					
		
		transferidor.download(host, absoluteRemoteFile, diretorioRecebidos);	
		
	}

}
