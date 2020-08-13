package br.com.atacadao.reportsadmin.model.tarefa;

import java.io.File;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.Servidor;
import br.com.atacadao.reportsadmin.model.StatusRelatorio;
import br.com.atacadao.reportsadmin.model.Tarefa;
import br.com.atacadao.reportsadmin.model.dao.ServidorDAO;
import br.com.atacadao.reportsadmin.model.dao.TarefaDAO;


@Service
@Transactional
@EnableScheduling
public class ApagaRelatoriosAntigosTarefa {
	
	
	private static final Logger log = LoggerFactory.getLogger(ApagaRelatoriosAntigosTarefa.class);

	@Autowired
	private TarefaDAO tarefaDAO;

	@Autowired
	private ServidorDAO servidorDAO;

	private static final String TIME_ZONE = "America/Sao_Paulo";

	// https://www.freeformatter.com/cron-expression-generator-quartz.html
	// 0 0 6 * * ? - Todo dia as 06:00AM
	// 0/60 * * * * * - A cada 30 segundos
	//@Scheduled(cron = "0 0 23 * * ?", zone = TIME_ZONE)
	public void executar() {

		Tarefa tarefa = tarefaDAO.findByNome("ApagaRelatoriosDiariosTarefa");

		if (tarefa != null && tarefa.isLigado()) {

			Calendar dataHora = Calendar.getInstance();

			

			log.info("Atualizando data de execucao da tarefa para {}", dataHora.getTime());
			tarefa.setDt_ultima_execucao(dataHora);
			tarefaDAO.update(tarefa);

			log.info("ApagaRelatoriosAntigosTarefa foi executada com sucesso");

		} else {
			log.info("O serviço ApagaRelatoriosAntigosTarefa esta desativado");
		}
	}	
	

	private void excluiArquivosDe(PathDiretorioEnum dir) {
		
		log.info("Limpando diretórios...");

		File diretorio = new File(dir.getPath());

		for (File file : diretorio.listFiles()) {
			if (file.isFile()) {
				file.delete();
				log.info("Arquivo {} deletado do  diretorio {}", file.getName(), dir.getPath());
			}
		}
		
		log.info("Processo de limpeza de diretorios finalizada!");
	}

}
