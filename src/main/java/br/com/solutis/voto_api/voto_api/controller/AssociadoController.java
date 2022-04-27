package br.com.solutis.voto_api.voto_api.controller;

import br.com.solutis.voto_api.voto_api.controller.dto.AssociadoDto;
import br.com.solutis.voto_api.voto_api.model.Associado;
import br.com.solutis.voto_api.voto_api.repository.AssociadoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController @RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @ApiOperation(value = "Retorna uma lista de associados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de associados"),
            @ApiResponse(code = 401, message = "Você não tem autorização para ver a lista"),
            @ApiResponse(code = 403, message = "Você está proibido de ver a lista"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),

    })
    @GetMapping
    public List<AssociadoDto> listar() {
        List<Associado> associados = associadoRepository.findAll();
        return AssociadoDto.converter(associados);
    }
}
