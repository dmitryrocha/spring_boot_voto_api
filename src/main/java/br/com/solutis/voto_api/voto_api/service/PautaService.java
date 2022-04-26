package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.model.StatusVotacao;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;

import java.util.Optional;

public class PautaService {

    public static void finalizarVotacao(Long pauta_id, PautaRepository pautaRepository) {

        Pauta pauta = pautaRepository.getById(pauta_id);
        System.out.println(pauta.getTitulo());
        pauta.setStatusVotacao(StatusVotacao.FECHADA);
        pautaRepository.save(pauta);
    }

    public Pauta atualizarStatus(PautaRepository pautaRepository, Long pauta_id) {
        Optional<Pauta> optional = pautaRepository.findById(pauta_id);
        Pauta pauta = null;
        if(optional.isPresent()) {
            pauta = optional.get();
            if (pauta.getStatusVotacao() == StatusVotacao.CRIADA) {
                pauta.setStatusVotacao(StatusVotacao.INICIADA);
                return pauta;
            }
        }
        return null;
    }
}
