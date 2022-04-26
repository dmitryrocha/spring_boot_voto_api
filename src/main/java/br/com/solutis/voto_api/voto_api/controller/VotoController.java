package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.VotoDto;
import br.com.solutis.voto_api.voto_api.model.Voto;
import br.com.solutis.voto_api.voto_api.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @GetMapping
    public List<VotoDto> lista() {
        List<Voto> votos = votoRepository.findAll();
        return VotoDto.converter(votos);
    }
}
