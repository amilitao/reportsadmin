package br.com.atacadao.reportsadmin.model.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Correio {
	
	//private static final Logger log = LoggerFactory.getLogger(Correio.class);

	@Autowired
	private Mailer mailer;

	public void envia(Email email) {
		
	//	log.info("Enviando email com o relatorio {} anexo para o funcionario {}", 
	//			email.getAttachment().getName(), email.getTo());

		mailer.sendEmail(email);
		
	//	log.info("Email enviado com sucesso!");

	}

}
