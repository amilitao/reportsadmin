package br.com.atacadao.reportsadmin.model.tarefa;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.Servidor;
import br.com.atacadao.reportsadmin.model.Tarefa;
import br.com.atacadao.reportsadmin.model.dao.ServidorDAO;
import br.com.atacadao.reportsadmin.model.dao.TarefaDAO;

@Service
@Transactional
@EnableScheduling
public class BuscaRelatoriosTarefa {

	@Autowired
	private TarefaDAO tarefaDAO;

	@Autowired
	private ServidorDAO servidorDAO;	
	

	private static final Logger log = LoggerFactory.getLogger(BuscaRelatoriosTarefa.class);

	private static final String TIME_ZONE = "America/Sao_Paulo";

	// https://www.freeformatter.com/cron-expression-generator-quartz.html
	// 0 0 6 * * ? - Todo dia as 06:00AM
	// 0/60 * * * * * - A cada 30 segundos
	// @Scheduled(cron = "0 30 6 * * ?", zone = TIME_ZONE)
	public void executar() {

		Tarefa tarefa = tarefaDAO.findByNome("BuscaRelatoriosTarefa");

		if (tarefa != null && tarefa.isLigado()) {

			Calendar dataHora = Calendar.getInstance();

			log.info("BuscaRelatoriosTarefa iniciado");

			List<Servidor> servidores = servidorDAO.list();

			for (Servidor servidor : servidores) {

				for (Relatorio relatorio : servidor.getRelatorios()) {

					

				}

			}

			log.info("Atualizando data de execucao da tarefa para {}", dataHora.getTime());
			
			tarefa.setDt_ultima_execucao(dataHora);			

			log.info("BuscaRelatoriosTarefa encerrado");

		} else {
			
			log.info("Tarefa BuscaRelatoriosTarefa esta desativado");
		}
	}

}
