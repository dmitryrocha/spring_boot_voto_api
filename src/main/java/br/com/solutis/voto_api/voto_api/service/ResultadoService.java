package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Resultado;
import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.model.ValorVoto;
import br.com.solutis.voto_api.voto_api.model.Voto;

import java.util.List;

public class ResultadoService {

    private ResultadoService() {}

    public static Resultado calcular(Sessao sessao) {
        double sim=0;
        double nao=0;
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

        return resultado;
    }
}
