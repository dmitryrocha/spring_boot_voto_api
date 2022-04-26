package br.com.solutis.voto_api.voto_api.controller.dto;

import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.model.StatusVotacao;

import java.util.List;
import java.util.stream.Collectors;

public class PautaDto {

    private Long id;
    private String titulo;
    private String descricao;
    private StatusVotacao statusVotacao = StatusVotacao.CRIADA;

    public PautaDto(Pauta pauta) {
        this.id = pauta.getId();
        this.titulo = pauta.getTitulo();
        this.descricao = pauta.getDescricao();
        this.statusVotacao = pauta.getStatusVotacao();
    }

    public static List<PautaDto> converter(List<Pauta> pautas) {
        return pautas.stream().map(PautaDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusVotacao getStatusVotacao() {
        return statusVotacao;
    }
}
