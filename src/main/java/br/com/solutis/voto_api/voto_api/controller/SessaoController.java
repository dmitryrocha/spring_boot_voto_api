package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.SessaoDto;
import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/sessao")
public class SessaoController {

    @Autowired
    private SessaoRepository sessaoRepository;

    @GetMapping
    public List<SessaoDto> listar() {
        List<Sessao> sessoes = sessaoRepository.findAll();
        return SessaoDto.converter(sessoes);
    }
}
