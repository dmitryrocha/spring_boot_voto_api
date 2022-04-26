package br.com.solutis.voto_api.voto_api.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Associado associado;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sessao sessao;
    private LocalDateTime horaDoVoto = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private ValorVoto valorVoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public LocalDateTime getHoraDoVoto() {
        return horaDoVoto;
    }

    public void setHoraDoVoto(LocalDateTime hodaDoVoto) {
        this.horaDoVoto = hodaDoVoto;
    }

    public ValorVoto getValorVoto() {
        return valorVoto;
    }

    public void setValorVoto(ValorVoto valorVoto) {
        this.valorVoto = valorVoto;
    }
}
