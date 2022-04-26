package br.com.solutis.voto_api.voto_api.controller.dto;

import br.com.solutis.voto_api.voto_api.model.Sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessaoDto {

    private Long id;
    private Long pauta;
    private List<VotoDto> votos;
    private LocalDateTime inicioDaSessao;
    private LocalDateTime fimDaSessao;

    public SessaoDto(Sessao sessao) {
        this.id = sessao.getId();
        this.pauta = sessao.getPauta().getId();
        this.votos = new ArrayList<>();
        this.inicioDaSessao = sessao.getInicioDaSessao();
        this.fimDaSessao = sessao.getFimDaSessao();

        if(sessao.getVotos() != null) {
            this.votos.addAll(sessao.getVotos().stream().map(VotoDto::new).collect(Collectors.toList()));
        }
    }

    public static List<SessaoDto> converter(List<Sessao> sessoes) {
        return sessoes.stream().map(SessaoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPauta() {
        return pauta;
    }

    public void setPauta(Long pauta) {
        this.pauta = pauta;
    }

    public List<VotoDto> getVotos() {
        return votos;
    }

    public void setVotos(List<VotoDto> votos) {
        this.votos = votos;
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
}
