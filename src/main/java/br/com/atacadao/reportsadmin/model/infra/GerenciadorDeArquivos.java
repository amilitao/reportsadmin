package br.com.atacadao.reportsadmin.model.infra;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;
import br.com.atacadao.reportsadmin.model.jsch.Transfer;
import br.com.atacadao.reportsadmin.model.pdf.ConversorDeRelatorio;

@Component
public class GerenciadorDeArquivos {

	@Autowired
	private Transfer transfer;

	public boolean atualiza(Relatorio relatorio) {

		limpaDiretorioRecebidos();

		transfer.recebe(relatorio);

		moveRecebidos();

		if (relatorio.getTipoRelatorio().equals(TipoRelatorio.PDF)) {
			ConversorDeRelatorio conversor = new ConversorDeRelatorio();
			conversor.converteTxtParaPdf(relatorio);
		}

		if (relatorio.getTipoRelatorio().getRepositorio().ehDisponivel(relatorio)) {

			return true;
		}

		return false;

	}

	private void limpaDiretorioRecebidos() {

		File dir_recebidos = new File(PathDiretorioEnum.DIR_RECEBIDOS.getPath());

		for (File recebido : dir_recebidos.listFiles()) {
			recebido.delete();
		}

	}

	private void moveRecebidos() {

		File dir_recebidos = new File(PathDiretorioEnum.DIR_RECEBIDOS.getPath());

		for (File recebido : dir_recebidos.listFiles()) {

			TipoRelatorio tipo = indentificaTipoDeArquivo(recebido.getName());

			tipo.getRepositorio().adiciona(recebido, identificaNomeRelatorio(recebido));

		}

	}

	/**
	 * *
	 * 
	 * @param recebido
	 * @return * Caso seja adicionado um novo tipo de arquivo ao sistema, será
	 *         necessario incluir o tipo do arquivo no metodo abaixo para que possa
	 *         ser identificado
	 */

	private TipoRelatorio indentificaTipoDeArquivo(String recebido) {

		String ext = recebido.substring(recebido.length() - 4, recebido.length());

		if (ext.equals(TipoRelatorio.PDF.getExtensao())) {
			return TipoRelatorio.PDF;
		} else if (ext.equals(TipoRelatorio.CSV.getExtensao())) {
			return TipoRelatorio.CSV;
		} else {
			return TipoRelatorio.TXT;
		}

	}

	private String identificaNomeRelatorio(File file) {

		String numero;
		String fileName = file.getName();
		String nome = fileName.substring(0, fileName.indexOf("."));

		if (fileName.contains("f")) {
			numero = fileName.substring(fileName.indexOf("f") + 1, fileName.indexOf("f") + 4);
		} else {
			numero = fileName.substring(fileName.indexOf(".") + 1, fileName.indexOf(".") + 4);
		}

		return nome + ".f" + numero;
	}

}
