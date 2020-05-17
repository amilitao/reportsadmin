package br.com.atacadao.reportsadmin.model.jsch;

import java.io.File;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

@Service
public class Sftp {

	private JSch jsch;
	private ChannelSftp channelSftp;

	public Sftp() {
		this.jsch = new JSch();
		this.channelSftp = new ChannelSftp();
	}

	public void transfere(DadosParaTransferencia dados) throws Exception {

		Session jschSession;

		try {

			jschSession = jsch.getSession(dados.getLogin(), dados.getHost());
			jschSession.setPassword(dados.getPassword());

			jschSession.setConfig("PreferredAuthentications", "password");

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");

			jschSession.setConfig(config);
			jschSession.connect();
			channelSftp = (ChannelSftp) jschSession.openChannel("sftp");

			channelSftp.connect();

			channelSftp.get(dados.getAbsoluteRemoteFile() + "*", dados.getAbsoluteLocalFile() + File.separator);

		} catch (JSchException | SftpException ex) {			
				throw new Exception("Erro ao transferir arquivo: " + ex.getMessage() 
						+ " | Dados de transferencia: Arquivo: " + dados.getAbsoluteRemoteFile()
						+ " - Servidor: " + dados.getHost());	
		} finally {
			channelSftp.exit();
		}

	}
}
