package br.com.atacadao.reportsadmin.model.pdf;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.DocumentException;

public class ConverterUtil {

	private static final Logger log = LoggerFactory.getLogger(ConverterUtil.class);
	
	private Converter converter;

	public ConverterUtil(Converter converter) {
		this.converter = converter;
	}

	public void converteTxtParaPdf(File arquivo, int tamanhoFonte) throws DocumentException, IOException {

		log.info("Convertendo relatorio {}", arquivo.getName());		

		converter.toPdf(arquivo, tamanhoFonte);
		
		log.info("Relatorio {} convertido com sucesso!", arquivo.getName());


	}

}
