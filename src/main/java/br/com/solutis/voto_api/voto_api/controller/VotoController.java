package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.VotoDto;
import br.com.solutis.voto_api.voto_api.model.Voto;
import br.com.solutis.voto_api.voto_api.model.VotoForm;
import br.com.solutis.voto_api.voto_api.repository.AssociadoRepository;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;
import br.com.solutis.voto_api.voto_api.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public List<VotoDto> lista() {
        List<Voto> votos = votoRepository.findAll();
        return VotoDto.converter(votos);
    }

    @PostMapping @Transactional
    public ResponseEntity<VotoDto> cadastrar(@RequestBody VotoForm votoForm, UriComponentsBuilder uriComponentsBuilder) {
        Voto voto = votoForm.converter(associadoRepository, sessaoRepository);
        votoRepository.save(voto);

        URI uri = uriComponentsBuilder.path("/votos/{id}").buildAndExpand(voto.getId()).toUri();

        return ResponseEntity.created(uri).body(new VotoDto(voto));
    }
}
