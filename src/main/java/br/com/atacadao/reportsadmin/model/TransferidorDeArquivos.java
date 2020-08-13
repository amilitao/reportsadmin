package br.com.atacadao.reportsadmin.model;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.atacadao.reportsadmin.model.jsch.Sftp;

public class TransferidorDeArquivos {
	
	@Autowired
	private CredencialSftp credencial;
	
	public TransferidorDeArquivos(CredencialSftp credencial) {
		this.credencial = credencial;
	}
	

	public void download(String host, String absoluteRemoteFile, String absoluteLocalFile) {
					
		Sftp sftp = new Sftp(this.credencial.getLogin(), this.credencial.getPassword());
		sftp.download(host, absoluteRemoteFile, absoluteLocalFile);

	}
	
	public void upload(String host, String absoluteRemoteFile, String absoluteLocalFile) {
				
		Sftp sftp = new Sftp(this.credencial.getLogin(), this.credencial.getPassword());
		sftp.upload(host, absoluteRemoteFile, absoluteLocalFile);

	}

}
