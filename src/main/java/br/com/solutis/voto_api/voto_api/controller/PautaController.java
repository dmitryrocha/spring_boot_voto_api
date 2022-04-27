package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.PautaDto;
import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.model.PautaForm;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
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

@RestController @RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @ApiOperation(value = "Retorna uma lista de pautas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pautas"),
            @ApiResponse(code = 401, message = "Você não tem autorização para ver a lista"),
            @ApiResponse(code = 403, message = "Você está proibido de ver a lista"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @GetMapping
    public List<PautaDto> listar() {
        List<Pauta> pautas = pautaRepository.findAll();
        return PautaDto.converter(pautas);
    }

    @ApiOperation(value = "Cadastra uma pauta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Cadastro criado com sucesso"),
            @ApiResponse(code = 401, message = "Você não tem autorização realizar cadastro"),
            @ApiResponse(code = 403, message = "Você está proibido de realizar cadastro"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @PostMapping @Transactional
    public ResponseEntity<PautaDto> cadastrar(@RequestBody @Valid PautaForm pautaForm, UriComponentsBuilder uriBuilder) {
        Pauta pauta = pautaForm.converter();
        pautaRepository.save(pauta);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(uri).body(new PautaDto(pauta));
    }

}
