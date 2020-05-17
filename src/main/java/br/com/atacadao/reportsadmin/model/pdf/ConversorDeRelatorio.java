package br.com.atacadao.reportsadmin.model.pdf;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class ConversorDeRelatorio {	

	// Converter converter = new ShellConverter();
	private Converter converter = new ItextConverter();
	

	public void converteTxtParaPdf(Relatorio relatorio) {
		
		File file = new File(PathDiretorioEnum.DIR_TXT.getPath() + relatorio.getNome() + ".f" + relatorio.getServidor().getNumero());

		ConverterUtil util = new ConverterUtil(converter);

		util.converteTxtParaPdf(file, relatorio.getTamanhoFonte());

	}

}
