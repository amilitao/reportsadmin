package br.com.atacadao.reportsadmin.model.jsch;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class Sftp {

	private String login;
	private String password;
	private ConnectionSftpFactory csf;
	private ChannelSftp channelSftp;

	public Sftp(String login, String password) {
		this.login = login;
		this.password = password;
		this.channelSftp = new ChannelSftp();
		this.csf = new ConnectionSftpFactory();
	}

	public void download(String host, String absoluteRemoteFile, String absoluteLocalFile) {

		try {

			this.channelSftp = csf.connect(host, login, password);
			this.channelSftp.get(absoluteRemoteFile, absoluteLocalFile);

		} catch (JSchException | SftpException ex) {
			System.out.println("Erro ao fazer download de arquivo! " + ex.getMessage());
		} finally {
			csf.disconnect();
		}

	}

	public void upload(String host, String absoluteRemoteFile, String absoluteLocalFile) {

		try {

			this.channelSftp = csf.connect(host, login, password);
			this.channelSftp.put(absoluteLocalFile, absoluteRemoteFile);

		} catch (JSchException | SftpException ex) {
			System.out.println("Erro ao fazer upload de arquivo! " + ex.getMessage());
		} finally {
			csf.disconnect();
		}

	}

}
