package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.controller.dto.PautaDto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PautaForm {

    @NotNull @NotEmpty @Length(min=3)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10)
    private String descricao;


    public Pauta converter() {
        Pauta pauta = new Pauta();
        pauta.setTitulo(this.titulo);
        pauta.setDescricao(this.descricao);
        return pauta;
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
    

}
