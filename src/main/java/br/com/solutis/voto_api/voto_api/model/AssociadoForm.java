package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.service.CpfService;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AssociadoForm {

    @NotNull @NotEmpty @Length(min=3)
    private String nome;
    @NotNull @NotEmpty
    private String cpf;

    public Associado converter() {
        Associado associado = new Associado();
        associado.setNome(this.nome);
        if (CpfService.validarCPF(this.cpf)) {
            associado.setCpf(this.cpf);
        } else {
            return null;
        }
        return associado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
