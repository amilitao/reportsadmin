package br.com.atacadao.reportsadmin.model;

import org.springframework.stereotype.Service;

@Service
public class Correio {

	public void envia(Email email) {
	System.out.println("Enviou um email");
		
	}

}
