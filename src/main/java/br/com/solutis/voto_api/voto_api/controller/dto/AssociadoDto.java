package br.com.solutis.voto_api.voto_api.controller.dto;

import br.com.solutis.voto_api.voto_api.model.Associado;

import java.util.List;
import java.util.stream.Collectors;

public class AssociadoDto {

    private String nome;
    private String cpf;

    public AssociadoDto(Associado associado) {
        this.nome = associado.getNome();
        this.cpf = associado.getCpf();
    }

    public static List<AssociadoDto> converter(List<Associado> associados) {
        return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
