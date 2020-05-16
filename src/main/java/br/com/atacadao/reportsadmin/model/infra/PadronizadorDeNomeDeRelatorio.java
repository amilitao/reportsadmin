package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;


public class PadronizadorDeNomeDeRelatorio {
	
	public File executa(File arquivo) {

		String path = "";
		String numero = "";

		String fileName = arquivo.getName();
		String nome = fileName.substring(0, fileName.indexOf("."));
		String ext = fileName.substring(fileName.length() - 4, fileName.length());

		if (fileName.contains("f")) {

			numero = fileName.substring(fileName.indexOf("f") + 1, fileName.indexOf("f") + 4);

		} else {

			numero = fileName.substring(fileName.indexOf(".") + 1, fileName.indexOf(".") + 4);

		}

		String nomeDoArquivoSemExtensao = PathDiretorioEnum.DIR_RECEBIDOS.getPath() + File.separator + nome + ".f" + numero;

		if (ext.equals(TipoRelatorio.PDF.getExtensao())) {

			arquivo.delete();

		} else if (ext.equals(TipoRelatorio.CSV.getExtensao())) {

			path = nomeDoArquivoSemExtensao + TipoRelatorio.CSV.getExtensao();

			arquivo.renameTo(new File(path));

		} else {

			path = nomeDoArquivoSemExtensao;

			arquivo.renameTo(new File(path));

		}

		return new File(path);

	}

}
