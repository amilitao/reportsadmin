package br.com.atacadao.reportsadmin.model.pdf;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;

public class ShellConverter implements Converter {
	

	@Override
	public void toPdf(File arquivo, int tamanhoFonte) throws DocumentException, IOException {
				
		if (arquivo.length() == 0) {
			throw new DocumentException("Arquivo sem conteudo");
		}
		
		File pdf = new File(PathDiretorioEnum.DIR_PDF.getPath() 
				+ arquivo.getName() + TipoRelatorio.PDF.getExtensao());

		final ArrayList<String> commands = new ArrayList<String>();

		commands.add("/bin/bash");
		commands.add("-c");
		commands.add("enscript " + arquivo.toString() + " -f Courier@" + tamanhoFonte + "/"
				+ tamanhoFonte + "--lines-per-page=66 --header= --margins=0:20:0:20 -r -o - | ps2pdf - "
				+ pdf.toString());
	
		BufferedReader br = null;

		final ProcessBuilder p = new ProcessBuilder(commands);

		final Process process = p.start();
		final InputStream is = process.getInputStream();
		final InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);

		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		secureClose(br);

	}

	private void secureClose(final Closeable resource) throws IOException {
		
			if (resource != null) {
				resource.close();
			}
		
	}

}
