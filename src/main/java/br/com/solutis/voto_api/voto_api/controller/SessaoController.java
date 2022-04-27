package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.SessaoDto;
import br.com.solutis.voto_api.voto_api.model.Resultado;
import br.com.solutis.voto_api.voto_api.model.Sessao;
import br.com.solutis.voto_api.voto_api.model.SessaoForm;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Retorna uma lista de sessões cadastradas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de sessões"),
            @ApiResponse(code = 401, message = "Você não tem autorização para ver a lista"),
            @ApiResponse(code = 403, message = "Você está proibido de ver a lista"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @GetMapping
    public List<SessaoDto> listar() {
        List<Sessao> sessoes = sessaoRepository.findAll();
        return SessaoDto.converter(sessoes);
    }

    @ApiOperation(value = "Inicia uma sessão")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Sessão iniciada com sucesso"),
            @ApiResponse(code = 401, message = "Você não tem autorização realizar cadastro"),
            @ApiResponse(code = 403, message = "Você está proibido de realizar cadastro"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @PostMapping({"/iniciar"})
    @Transactional
    public ResponseEntity<SessaoDto> iniciar(@RequestBody @Valid SessaoForm sessaoForm, UriComponentsBuilder uriComponentsBuilder) {
        Sessao sessao = sessaoForm.converter(pautaRepository);
        sessaoRepository.save(sessao);

        URI uri = uriComponentsBuilder.path("/sessao/{id}").buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(uri).body(new SessaoDto(sessao));
    }

    @ApiOperation(value = "Chama o resultado de uma sessão de votação específica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Traz o resultado absoluto, a porcenbtagem e o vencedor da votação"),
            @ApiResponse(code = 401, message = "Você não tem autorização ver o resultado"),
            @ApiResponse(code = 403, message = "Você está proibido de ver o resultado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @GetMapping({"/resultado/{id}"})
    public ResponseEntity<Resultado> resultado(@PathVariable Long id) {
        Optional<Sessao> optional = sessaoRepository.findById(id);
        if(optional.isPresent()) {
            return optional.map(sessao -> ResponseEntity.ok(new Resultado(sessao))).orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();

    }
}
