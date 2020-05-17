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

		try {

			transfer.recebe(relatorio);

			moveRecebidos();			
			
			if(relatorio.getTipoRelatorio().equals(TipoRelatorio.PDF)) {
				ConversorDeRelatorio conversor = new ConversorDeRelatorio();
				conversor.converteTxtParaPdf(relatorio);
			}	
			
			return true;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	private void moveRecebidos() {

		File dir_recebidos = new File(PathDiretorioEnum.DIR_RECEBIDOS.getPath());

		for (File recebido : dir_recebidos.listFiles()) {

			TipoRelatorio tipo = indentificaTipoRelatorio(recebido.getName());

			tipo.getRepositorio().adiciona(recebido, identificaNomeRelatorio(recebido));

		}

	}

	private TipoRelatorio indentificaTipoRelatorio(String recebido) {

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
