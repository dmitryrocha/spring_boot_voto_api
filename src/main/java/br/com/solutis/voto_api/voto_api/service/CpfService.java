package br.com.solutis.voto_api.voto_api.service;

import org.springframework.web.client.RestTemplate;

public class CpfService {

    private CpfService() {}

    public static boolean validarCPF(String cpf) {
        String url =  "https://cpf-api-almfelipe.herokuapp.com/cpf/"+cpf;
        RestTemplate restTemplate = new RestTemplate();
        String valido = restTemplate.getForObject(url, String.class);
        assert valido != null;
        return valido.contains("true");
    }

}
