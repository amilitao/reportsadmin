package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;

public class RepositorioTXT implements Repositorio {

	private String path = PathDiretorioEnum.DIR_TXT.getPath();

	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public void adiciona(File file, String novoNome) {

		file.renameTo(new File(path + novoNome));

	}

	@Override
	public boolean ehDisponivel(Relatorio relatorio) {

		File file = new File(path + relatorio.getNomeArquivo());

		return file.exists();
	}

}
