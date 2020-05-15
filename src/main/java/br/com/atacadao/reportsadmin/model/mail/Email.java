package br.com.atacadao.reportsadmin.model.mail;

import java.io.File;

import br.com.atacadao.reportsadmin.model.Funcionario;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class Email {

	private String from = "producao@atacadao.com.br";;
	private String to;
	private String subject;
	private String content;
	private File attachment;

	public Email(Funcionario funcionario, Relatorio relatorio) {
		this.to = funcionario.getEmail();
		this.subject = relatorio.getNomeArquivo() + " - " + relatorio.getDescricao();
		this.content = "Segue anexo relatorio " + relatorio.getNomeArquivo();
		
		File anexo = relatorio.getFile();		
		
		if (anexo != null) {
			this.setAttachment(anexo);
		}
		
		
		System.out.println("Criou um email");
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

}
