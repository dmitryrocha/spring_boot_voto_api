package br.com.solutis.voto_api.voto_api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sessao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pauta pauta;
    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL)
    private List<Voto> votos;
    private LocalDateTime inicioDaSessao;
    private LocalDateTime fimDaSessao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
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
