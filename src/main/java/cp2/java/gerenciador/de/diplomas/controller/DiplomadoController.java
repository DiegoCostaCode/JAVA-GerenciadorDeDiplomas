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

import java.util.List;
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

    @GetMapping("/buscar")
    public ResponseEntity<List<Diplomado>> readDiplomado() {
        List<Diplomado> diplomados = diplomadoRepository.findAll();
        if (diplomados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(diplomados, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Diplomado> readDiplomadoById(@PathVariable Long id) {
        Optional<Diplomado> diplomado = diplomadoRepository.findById(id);
        if (diplomado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(diplomado.get(), HttpStatus.OK);
    }

    @PutMapping("/atualizar-cadastro/{id}")
    public ResponseEntity<Diplomado> updateDiplomado(@PathVariable Long id, @Valid @RequestBody DiplomadoRequestDTO diplomadoRequest) {
        Optional<Diplomado> diplomado = diplomadoRepository.findById(id);
        if (diplomado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Diplomado diplomadoSalvo = diplomadoMapper.requestRecordToDiplomado(diplomadoRequest);
        diplomadoSalvo.setId_diplomado(id);
        diplomadoRepository.save(diplomadoSalvo);
        return new ResponseEntity<>(diplomadoSalvo, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteDiplomado(@PathVariable Long id) {
        Optional<Diplomado> diplomado = diplomadoRepository.findById(id);
        if (diplomado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        diplomadoRepository.delete(diplomado.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
