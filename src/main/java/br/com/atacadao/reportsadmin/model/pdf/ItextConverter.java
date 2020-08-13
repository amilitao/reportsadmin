package br.com.atacadao.reportsadmin.model.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.TipoRelatorio;

public class ItextConverter implements Converter {

	@Override
	public void toPdf(File arquivo, int tamanhoFonte) throws DocumentException, IOException {

		LeitorDeArquivo leitor = new LeitorDeArquivo(arquivo);
	
		if (leitor.getLinhas().isEmpty()) {
			throw new DocumentException("Arquivo sem conteudo");
		}
		
		File pdf = new File(PathDiretorioEnum.DIR_REPOSITORIO.getPath() 
				+ arquivo.getName() + TipoRelatorio.PDF.getExtensao());


		Document document = new Document(PageSize.A4.rotate());

		if (tamanhoFonte == 0) {
			tamanhoFonte = 7;
		}

		Font font = new Font(Font.FontFamily.COURIER, tamanhoFonte);

		PdfWriter.getInstance(document, new FileOutputStream(pdf.getAbsolutePath()));
		document.open();

		for (String linha : leitor.getLinhas()) {
			document.add(new Paragraph(linha, font));
		}

		document.close();

	}

}
