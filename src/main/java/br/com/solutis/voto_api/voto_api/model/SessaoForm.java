package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
import br.com.solutis.voto_api.voto_api.service.PautaService;
import br.com.solutis.voto_api.voto_api.service.FechaVotacaoService;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SessaoForm {

    @NotNull
    private Long pauta;
    private LocalDateTime inicioDaSessao = LocalDateTime.now();
    private LocalDateTime fimDaSessao;

    public Long getPauta() {
        return pauta;
    }

    public void setPauta(Long pauta) {
        this.pauta = pauta;
    }

    public LocalDateTime getInicioDaSessao() {
        return inicioDaSessao;
    }

    public void setInicioDaSessao(LocalDateTime inicioDaSessao) {
        this.inicioDaSessao = inicioDaSessao;
    }

    public LocalDateTime getFimDaSessao() {
        return fimDaSessao;
    }

    public void setFimDaSessao(LocalDateTime fimDaSessao) {
        this.fimDaSessao = fimDaSessao;
    }

    public Sessao converter(PautaRepository pautaRepository) {
        Sessao sessao = new Sessao();
        Pauta pautaConverter = new PautaService().atualizarStatus(pautaRepository, pauta);
        if (pautaConverter == null) {
            return null;
        }
        if(fimDaSessao == null) {
            this.fimDaSessao = inicioDaSessao.plusMinutes(1);
        }
        sessao.setPauta(pautaConverter);
        sessao.setInicioDaSessao(this.inicioDaSessao);
        sessao.setFimDaSessao(fimDaSessao);

        FechaVotacaoService.fecharVotacao(sessao, pautaRepository);

        return sessao;
    }

}
