package br.com.atacadao.reportsadmin.model.tarefa;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.atacadao.reportsadmin.model.Funcionario;
import br.com.atacadao.reportsadmin.model.Relatorio;
import br.com.atacadao.reportsadmin.model.StatusRelatorio;
import br.com.atacadao.reportsadmin.model.Tarefa;
import br.com.atacadao.reportsadmin.model.dao.FuncionarioDAO;
import br.com.atacadao.reportsadmin.model.dao.TarefaDAO;
import br.com.atacadao.reportsadmin.model.mail.Correio;
import br.com.atacadao.reportsadmin.model.mail.Email;

@Service
@Transactional
@EnableScheduling
public class EnviaRelatoriosTarefa {

	@Autowired
	private TarefaDAO tarefaDAO;

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private Correio correio;

	private static final Logger log = LoggerFactory.getLogger(EnviaRelatoriosTarefa.class);

	private static final String TIME_ZONE = "America/Sao_Paulo";

	// 0 0 6 * * ? - Todo dia as 06:00AM
	// 0/60 * * * * * - A cada 30 segundos
	@Scheduled(cron = "0 0 7 * * ?", zone = TIME_ZONE)
	public void executar() {

		Tarefa tarefa = tarefaDAO.findByNome("EnviaRelatoriosTarefa");

		if (tarefa != null && tarefa.isLigado()) {

			Calendar dataHora = Calendar.getInstance();

			log.info("EnviaRelatoriosTarefa iniciado");

			for (Funcionario funcionario : funcionarioDAO.list()) {

				for (Relatorio relatorio : funcionario.getRelatorios()) {

					if (relatorio.getStatus() == StatusRelatorio.DISPONIVEL) {

						correio.envia(new Email(funcionario, relatorio));

						log.info("Arquivo {} foi enviado para {}", relatorio.getNomeArquivo(), funcionario.getEmail());
					} else {

						log.info("Arquivo {} indisponivel", relatorio.getNomeArquivo());
					}
				}
			}

			log.info("Atualizando data de execucao da tarefa para {}", dataHora.getTime());

			tarefa.setDt_ultima_execucao(dataHora);

			log.info("EnviaRelatoriosTarefa finalizado");

		} else {
			log.info("Tarefa EnviaRelatoriosTarefa está desativado");
		}

	}

}