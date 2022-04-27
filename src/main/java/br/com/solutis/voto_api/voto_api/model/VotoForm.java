package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.repository.AssociadoRepository;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VotoForm {
    private Long associado;
    private Long sessao;
    @Enumerated(EnumType.STRING)
    private ValorVoto valorVoto;

    public Long getAssociado() {
        return associado;
    }

    public void setAssociado(Long associado) {
        this.associado = associado;
    }

    public Long getSessao() {
        return sessao;
    }

    public void setSessao(Long sessao) {
        this.sessao = sessao;
    }

    public ValorVoto getValorVoto() {
        return valorVoto;
    }

    public void setValorVoto(ValorVoto valorVoto) {
        this.valorVoto = valorVoto;
    }

    public Voto converter(AssociadoRepository associadoRepository, SessaoRepository sessaoRepository) {
        Associado associadoBD = associadoRepository.getById(this.associado);
        Sessao sessaoBD = sessaoRepository.getById(this.sessao);
        List<Voto> votos = sessaoBD.getVotos();
        List<Voto> duplicado = votos.stream().filter(p -> p.getAssociado() == associadoBD).collect(Collectors.toList());
        if(duplicado.isEmpty()) {
            return new Voto(associadoBD, sessaoBD, LocalDateTime.now(), this.valorVoto);
        } else {
            return null;
        }
    }
}
