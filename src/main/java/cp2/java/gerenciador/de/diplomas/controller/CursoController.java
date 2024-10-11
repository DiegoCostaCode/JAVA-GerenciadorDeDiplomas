package cp2.java.gerenciador.de.diplomas.controller;

import cp2.java.gerenciador.de.diplomas.dto.CursoRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.CursoResponseDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomadoRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomadoResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.repository.CursoRepository;
import cp2.java.gerenciador.de.diplomas.service.CursoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired(required = true)
    private CursoMapper cursoMapper;

    @Operation(summary = "Registrar curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso registrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos", content =  @Content(schema = @Schema()))
    })
    @PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CursoResponseDTO> createCurso(@Valid @RequestBody CursoRequestDTO cursoRequest)
    {
        Curso cursoSalvo = cursoMapper.requestRecordToCurso(cursoRequest);
        Curso cursoCriado = cursoRepository.save(cursoSalvo);

        CursoResponseDTO cursoResponseDTO = cursoMapper.cursoToResponseDTO(cursoCriado);
        return new ResponseEntity<>(cursoResponseDTO, HttpStatus.CREATED);
    }
}
