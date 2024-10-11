package cp2.java.gerenciador.de.diplomas.controller;

import cp2.java.gerenciador.de.diplomas.dto.DiplomaResponseDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomadoRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomadoResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diploma;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.model.Sexo;
import cp2.java.gerenciador.de.diplomas.repository.CursoRepository;
import cp2.java.gerenciador.de.diplomas.repository.DiplomaRepository;
import cp2.java.gerenciador.de.diplomas.repository.DiplomadoRepository;
import cp2.java.gerenciador.de.diplomas.service.DiplomadoMapper;
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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/diplomado")
public class DiplomadoController {


    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Autowired(required = true)
    private DiplomadoMapper diplomadoMapper;

    @Operation(summary = "Cria o diplomado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Diplomado registrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos", content =  @Content(schema = @Schema()))
    })
    @PostMapping(value = "/cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiplomadoResponseDTO> createDiplomado(@Valid @RequestBody DiplomadoRequestDTO diplomadoRequest)
    {
        Diplomado diplomadoSalvo = diplomadoMapper.requestRecordToDiplomado(diplomadoRequest);
        Diplomado diplomadoCriado = diplomadoRepository.save(diplomadoSalvo);

        DiplomadoResponseDTO diplomadoResponseDTO = diplomadoMapper.diplomadoToResponseDTO(diplomadoCriado);
        return new ResponseEntity<>(diplomadoResponseDTO, HttpStatus.CREATED);
    }

}
