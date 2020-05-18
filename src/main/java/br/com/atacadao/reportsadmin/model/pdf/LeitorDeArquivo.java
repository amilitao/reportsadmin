package br.com.atacadao.reportsadmin.model.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorDeArquivo {

	private File arquivo;
	private List<String> linhas = new ArrayList<>();

	public LeitorDeArquivo(File arquivo) {
		this.arquivo = arquivo;

	}

	public List<String> getLinhas() throws FileNotFoundException {

		Scanner scan = new Scanner(arquivo);

		while (scan.hasNextLine()) {

			linhas.add(scan.nextLine());

		}

		return this.linhas;

	}

}
