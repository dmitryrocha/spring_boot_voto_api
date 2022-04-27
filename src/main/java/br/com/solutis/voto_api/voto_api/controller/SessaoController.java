package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.SessaoDto;
import br.com.solutis.voto_api.voto_api.model.Resultado;
import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.model.SessaoForm;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/sessao")
public class SessaoController {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    @GetMapping
    public List<SessaoDto> listar() {
        List<Sessao> sessoes = sessaoRepository.findAll();
        return SessaoDto.converter(sessoes);
    }

    @PostMapping({"/iniciar"})
    @Transactional
    public ResponseEntity<SessaoDto> iniciar(@RequestBody @Valid SessaoForm sessaoForm, UriComponentsBuilder uriComponentsBuilder) {
        Sessao sessao = sessaoForm.converter(pautaRepository);
        sessaoRepository.save(sessao);

        URI uri = uriComponentsBuilder.path("/sessao/{id}").buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(uri).body(new SessaoDto(sessao));
    }

    @GetMapping({"/resultado/{id}"})
    public ResponseEntity<Resultado> resultado(@PathVariable Long id) {
        Optional<Sessao> optional = sessaoRepository.findById(id);
        return optional.map(sessao -> ResponseEntity.ok(new Resultado(sessao))).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
