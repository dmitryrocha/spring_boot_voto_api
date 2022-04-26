package br.com.solutis.voto_api.voto_api.model;

import javax.persistence.*;

@Entity
public class Pauta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusVotacao statusVotacao = StatusVotacao.CRIADA;

    public Pauta(){
    }

    public Pauta(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusVotacao getStatusVotacao() {
        return statusVotacao;
    }

    public void setStatusVotacao(StatusVotacao statusVotacao) {
        this.statusVotacao = statusVotacao;
    }
}
