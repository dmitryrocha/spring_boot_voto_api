package br.com.solutis.voto_api.voto_api.controller.dto;

import br.com.solutis.voto_api.voto_api.model.ValorVoto;
import br.com.solutis.voto_api.voto_api.model.Voto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VotoDto {

    private Long id;
    private Long idAssociado;
    private Long idSessao;
    private LocalDateTime horaDoVoto;
    private ValorVoto valorVoto;

    public VotoDto(Voto voto) {
        this.id = voto.getId();
        this.idAssociado = voto.getAssociado().getId();
        this.idSessao = voto.getSessao().getId();
        this.horaDoVoto = voto.getHoraDoVoto();
        this.valorVoto = voto.getValorVoto();
    }

    public static List<VotoDto> converter(List<Voto> votos) {
        return votos.stream().map(VotoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public LocalDateTime getHoraDoVoto() {
        return horaDoVoto;
    }

    public ValorVoto getValorVoto() {
        return valorVoto;
    }
}
