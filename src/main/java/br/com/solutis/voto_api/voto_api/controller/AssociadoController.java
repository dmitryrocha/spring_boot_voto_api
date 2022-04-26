package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.AssociadoDto;
import br.com.solutis.voto_api.voto_api.model.Associado;
import br.com.solutis.voto_api.voto_api.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public List<AssociadoDto> listar() {
        List<Associado> associados = associadoRepository.findAll();
        return AssociadoDto.converter(associados);
    }
}
