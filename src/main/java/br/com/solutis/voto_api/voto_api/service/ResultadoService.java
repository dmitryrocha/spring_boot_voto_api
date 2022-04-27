package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Resultado;
import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.model.ValorVoto;
import br.com.solutis.voto_api.voto_api.model.Voto;

import java.util.List;

public class ResultadoService {

    public static Resultado calcular(Sessao sessao) {
        double sim=0, nao=0;
        Resultado resultado = new Resultado();
        List<Voto> votos = sessao.getVotos();
        for (Voto voto : votos) {
            if (voto.getValorVoto() == ValorVoto.SIM) {
                sim++;
            } else {
                nao++;
            }
        }
        resultado.setVotosSim(sim);
        resultado.setVotosNao(nao);
        resultado.setPorcentagemSim((sim*100)/ votos.size());
        resultado.setPorcentagemNao((nao*100)/ votos.size());

        if(sim > nao) {
            resultado.setVencedor("SIM");
        } else if (sim < nao) {
            resultado.setVencedor("NAO");
        } else {
            resultado.setVencedor("EMPATE");
        }

//        votos.stream().map(t -> {
//            if(t.getValorVoto() == ValorVoto.SIM){
//                count.set(resultado.getQtdSim() + 1);
//                resultado.setQtdSim(count.get());
//            } else {
//                count.set(resultado.getQtdNao() + 1);
//                resultado.setQtdNao(count.get());
//            }
//            return null;
//        }).collect(Collectors.toList());
        return resultado;
    }
}
