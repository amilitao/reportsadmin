package br.com.atacadao.reportsadmin.model.tarefa;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.atacadao.reportsadmin.model.Repositorio;
import br.com.atacadao.reportsadmin.model.Tarefa;
import br.com.atacadao.reportsadmin.model.dao.TarefaDAO;

@Service
@Transactional
@EnableScheduling
public class ApagaRelatoriosAntigosTarefa {

	private static final Logger log = LoggerFactory.getLogger(ApagaRelatoriosAntigosTarefa.class);

	@Autowired
	private Repositorio repositorio;

	@Autowired
	private TarefaDAO tarefaDAO;
	

	private static final String TIME_ZONE = "America/Sao_Paulo";

	// https://www.freeformatter.com/cron-expression-generator-quartz.html
	// 0 0 6 * * ? - Todo dia as 06:00AM
	// 0/60 * * * * * - A cada 30 segundos
	// @Scheduled(cron = "0 0 23 * * ?", zone = TIME_ZONE)
	public void executar() {
		
		Tarefa tarefa = tarefaDAO.findByNome("ApagaRelatoriosDiariosTarefa");

		if (tarefa != null && tarefa.isLigado()) {

			repositorio.apagaRelatorios();
			
			tarefa.setDt_ultima_execucao(Calendar.getInstance());
			log.info("Data de execucao da tarefa atualizada para {}", tarefa.getDt_ultima_execucao());

			log.info("ApagaRelatoriosAntigosTarefa foi executada com sucesso");
		} else {
			log.info("O serviço ApagaRelatoriosAntigosTarefa esta desativado");
		}
	}

}
