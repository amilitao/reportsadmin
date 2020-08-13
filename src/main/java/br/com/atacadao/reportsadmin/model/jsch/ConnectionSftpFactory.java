package br.com.atacadao.reportsadmin.model.jsch;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConnectionSftpFactory {

	private ChannelSftp channelSftp = new ChannelSftp();
	private Session jschSession;
	private Channel channel;

	public void disconnect() {
		this.channelSftp.exit();
		this.channel.disconnect();
		this.jschSession.disconnect();
		
	}

	public ChannelSftp connect(String host, String login, String password) throws JSchException {

		JSch jsch = new JSch();

		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");

		jschSession = jsch.getSession(login, host);
		jschSession.setPassword(password);
		jschSession.setConfig("PreferredAuthentications", "password");
		jschSession.setConfig(config);
		jschSession.connect();
		
		channel = jschSession.openChannel("sftp");
		channel.connect();
		
		this.channelSftp = (ChannelSftp) channel;	

		return this.channelSftp;

	}

}
