package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.VotoDto;
import br.com.solutis.voto_api.voto_api.model.Voto;
import br.com.solutis.voto_api.voto_api.model.VotoForm;
import br.com.solutis.voto_api.voto_api.repository.AssociadoRepository;
import br.com.solutis.voto_api.voto_api.repository.SessaoRepository;
import br.com.solutis.voto_api.voto_api.repository.VotoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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

    @ApiOperation(value = "Retorna uma lista de votos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de votos"),
            @ApiResponse(code = 401, message = "Você não tem autorização para ver a lista"),
            @ApiResponse(code = 403, message = "Você está proibido de ver a lista"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @GetMapping
    public List<VotoDto> lista() {
        List<Voto> votos = votoRepository.findAll();
        return VotoDto.converter(votos);
    }

    @ApiOperation(value = "Cadastra um voto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Voto registrado com sucesso"),
            @ApiResponse(code = 401, message = "Você não tem autorização registrar um voto"),
            @ApiResponse(code = 403, message = "Você está proibido de registrar um voto"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @PostMapping @Transactional
    public ResponseEntity<VotoDto> cadastrar(@RequestBody VotoForm votoForm, UriComponentsBuilder uriComponentsBuilder) {
        Voto voto = votoForm.converter(associadoRepository, sessaoRepository);
        votoRepository.save(voto);

        URI uri = uriComponentsBuilder.path("/votos/{id}").buildAndExpand(voto.getId()).toUri();

        return ResponseEntity.created(uri).body(new VotoDto(voto));
    }
}
