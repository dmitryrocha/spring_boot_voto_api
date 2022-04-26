package br.com.solutis.voto_api.voto_api.controller.dto;

import br.com.solutis.voto_api.voto_api.model.ValorVoto;
import br.com.solutis.voto_api.voto_api.model.Voto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VotoDto {

    private Long id;
    private Long id_associado;
    private Long id_sessao;
    private LocalDateTime horaDoVoto;
    private ValorVoto valorVoto;

    public VotoDto(Voto voto) {
        this.id = voto.getId();
        this.id_associado = voto.getAssociado().getId();
        this.id_sessao = voto.getSessao().getId();
        this.horaDoVoto = voto.getHoraDoVoto();
        this.valorVoto = voto.getValorVoto();
    }

    public static List<VotoDto> converter(List<Voto> votos) {
        return votos.stream().map(VotoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public Long getId_associado() {
        return id_associado;
    }

    public Long getId_sessao() {
        return id_sessao;
    }

    public LocalDateTime getHoraDoVoto() {
        return horaDoVoto;
    }

    public ValorVoto getValorVoto() {
        return valorVoto;
    }
}
