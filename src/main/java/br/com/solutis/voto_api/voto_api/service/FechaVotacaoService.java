package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FechaVotacaoService {

    //private final ScheduledExecutorService ses;


    public static void fecharVotacao(Sessao sessao, PautaRepository pautaRepository) {

//        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
//        ScheduledFuture<?> contagemRegressiva = ses.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Acabou a votação");
//                PautaService.finalizarVotacao(sessao.getPauta().getId(), pautaRepository);
//            }
//        }, sessao.getInicioDaSessao().until(sessao.getFimDaSessao(), ChronoUnit.MINUTES), TimeUnit.MINUTES);
//
//        while(!contagemRegressiva.isDone()) {
//            try {
//                Thread.sleep(30000);
//                System.out.println("ainda não acabou");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("vai fechar");
//
//            ses.shutdown();
//        }
    }
}


