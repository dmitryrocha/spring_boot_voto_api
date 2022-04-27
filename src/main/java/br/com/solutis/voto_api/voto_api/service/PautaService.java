package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.model.StatusVotacao;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;

import java.util.Optional;

public class PautaService {

    public static void finalizarVotacao(Long pautaId, PautaRepository pautaRepository) {

        Pauta pauta = pautaRepository.getById(pautaId);
        pauta.setStatusVotacao(StatusVotacao.FECHADA);
        pautaRepository.save(pauta);
    }

    public Pauta atualizarStatus(PautaRepository pautaRepository, Long pautaId) {
        Optional<Pauta> optional = pautaRepository.findById(pautaId);
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
