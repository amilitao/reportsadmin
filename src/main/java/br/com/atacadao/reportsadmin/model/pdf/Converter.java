package br.com.atacadao.reportsadmin.model.pdf;


import java.io.File;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface Converter {	
	void toPdf(File arquivo, int tamanhoFonte) throws DocumentException, IOException;
}
