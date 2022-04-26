package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.repository.PautaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class SessaoForm {

    @NotNull @NotEmpty
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

//    public Sessao converter(PautaRepository pautaRepository) {
//        Optional<Pauta> optional = pautaRepository.findById(this.pauta);
//        if(optional.isPresent()) {
//            Pauta pauta = optional.get();
//            return new Sessao()
//        }
//        return null;
//    }
}
