package br.com.solutis.voto_api.voto_api.model;

import br.com.solutis.voto_api.voto_api.service.ResultadoService;

public class Resultado {


    private double votosSim;
    private double votosNao;
    private double porcentagemSim;
    private double porcentagemNao;
    private String vencedor;

    public Resultado() {}

    public Resultado(Sessao sessao) {
        Resultado resultado = ResultadoService.calcular(sessao);
        this.votosSim = resultado.getVotosSim();
        this.votosNao = resultado.getVotosNao();
        this.porcentagemSim = resultado.getPorcentagemSim();
        this.porcentagemNao = resultado.getPorcentagemNao();
        this.vencedor = resultado.getVencedor();
    }


    public double getVotosSim() {
        return votosSim;
    }

    public void setVotosSim(double votosSim) {
        this.votosSim = votosSim;
    }

    public double getVotosNao() {
        return votosNao;
    }

    public void setVotosNao(double votosNao) {
        this.votosNao = votosNao;
    }

    public double getPorcentagemSim() {
        return porcentagemSim;
    }

    public void setPorcentagemSim(double porcentagemSim) {
        this.porcentagemSim = porcentagemSim;
    }

    public double getPorcentagemNao() {
        return porcentagemNao;
    }

    public void setPorcentagemNao(double porcentagemNao) {
        this.porcentagemNao = porcentagemNao;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }
}
