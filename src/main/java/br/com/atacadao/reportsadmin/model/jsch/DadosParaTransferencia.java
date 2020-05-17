package br.com.atacadao.reportsadmin.model.jsch;

public class DadosParaTransferencia {
	
	private String host;
	private String absoluteRemoteFile;
	private String absoluteLocalFile;	
	private String login;
	private String password;
	
	
	public DadosParaTransferencia(String host, String absoluteRemoteFile, String absoluteLocalFile, String login, String password) {
		this.host = host;
		this.absoluteRemoteFile = absoluteRemoteFile;
		this.absoluteLocalFile = absoluteLocalFile;
		this.login = login;
		this.password = password;
	}


	public String getHost() {
		return host;
	}


	public String getAbsoluteRemoteFile() {
		return absoluteRemoteFile;
	}


	public String getAbsoluteLocalFile() {
		return absoluteLocalFile;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "DadosParaTransferencia [host=" + host + ", absoluteRemoteFile=" + absoluteRemoteFile
				+ ", absoluteLocalFile=" + absoluteLocalFile + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
	
}
