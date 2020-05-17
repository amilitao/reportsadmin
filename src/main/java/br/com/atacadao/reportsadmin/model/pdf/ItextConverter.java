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

public class ItextConverter implements Converter {

	@Override
	public void toPdf(File arquivo, int tamanhoFonte) throws DocumentException, IOException {

		LeitorDeArquivo leitor = new LeitorDeArquivo(arquivo);

		File pdf = new File(PathDiretorioEnum.DIR_PDF.getPath() 
				+ arquivo.getName() + ".pdf");

		if (leitor.getLinhas().isEmpty()) {
			System.out.println("Arquivo sem conteudo");
		}

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
