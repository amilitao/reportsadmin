package br.com.atacadao.reportsadmin.model.pdf;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.DocumentException;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class ConversorDeRelatorio {

	private static final Logger log = LoggerFactory.getLogger(ConversorDeRelatorio.class);

	// Converter converter = new ShellConverter();
	private Converter converter = new ItextConverter();

	public void converteTxtParaPdf(Relatorio relatorio) {

		File file = new File(
				PathDiretorioEnum.DIR_TXT.getPath() + relatorio.getNome() + ".f" + relatorio.getServidor().getNumero());

		ConverterUtil util = new ConverterUtil(converter);

		try {

			log.info("Iniciando conversão do arquivo {}", file.getName());

			if (file.exists()) {

				util.converteTxtParaPdf(file, relatorio.getTamanhoFonte());
				
				log.info("Arquivo {} convertido para PDF com sucesso", file.getName());

			}
			
			log.info("Arquivo {} não pode ser convertido. Falta arquivo txt", file.getName());

			

		} catch (DocumentException | IOException e) {
			log.error("Erro na conversão do arquivo {} : {}", file.getName(), e.getMessage());
		}

	}

}
