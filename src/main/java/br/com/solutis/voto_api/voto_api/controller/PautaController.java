package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.PautaDto;
import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.model.PautaForm;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @GetMapping
    public List<PautaDto> listar() {
        List<Pauta> pautas = pautaRepository.findAll();
        return PautaDto.converter(pautas);
    }

    @PostMapping @Transactional
    public ResponseEntity<PautaDto> cadastrar(@RequestBody @Valid PautaForm pautaForm, UriComponentsBuilder uriBuilder) {
        Pauta pauta = pautaForm.converter();
        pautaRepository.save(pauta);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(uri).body(new PautaDto(pauta));
    }

}
