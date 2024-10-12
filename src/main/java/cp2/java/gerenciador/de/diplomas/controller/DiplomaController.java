package cp2.java.gerenciador.de.diplomas.controller;

import cp2.java.gerenciador.de.diplomas.dto.DiplomaRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomaResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diploma;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.model.Sexo;
import cp2.java.gerenciador.de.diplomas.repository.CursoRepository;
import cp2.java.gerenciador.de.diplomas.repository.DiplomaRepository;
import cp2.java.gerenciador.de.diplomas.repository.DiplomadoRepository;
import cp2.java.gerenciador.de.diplomas.service.DiplomaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    @Autowired
    private DiplomaRepository diplomaRepository;

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired(required = true)
    private DiplomaMapper diplomaMapper;

    private String gerarTextoDiploma(DiplomaResponseDTO diplomaResponse) {
        // Geração do título e cargo do reitor
        String tituloReitor = (diplomaResponse.sexo_reitor() == Sexo.MASCULINO) ? "Prof. Dr. " + diplomaResponse.nome_reitor() : "Profa. Dra. " + diplomaResponse.nome_reitor();
        String cargoReitor = (diplomaResponse.sexo_reitor() == Sexo.FEMININO) ? "reitora" : "reitor";

        // Geração do texto do diploma
        return String.format(
                "O %s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta instituição de ensino no dia %s.",
                tituloReitor,
                cargoReitor,
                diplomaResponse.diplomado_id().getNome_diplomado(),
                diplomaResponse.diplomado_id().getNacionalidade_diplomado(),
                diplomaResponse.diplomado_id().getNaturalidade_diplomado(),
                diplomaResponse.diplomado_id().getRg_diplomado(),
                diplomaResponse.curso_id().getTipo_curso().toString(),
                diplomaResponse.curso_id().getNome_curso(),
                diplomaResponse.data_diploma().toString()
        );
    }


    @GetMapping("/buscar/{diplomado_id}")
    public ResponseEntity<String> getDiploma(@PathVariable UUID diplomado_id) {
        Optional<Diploma> diplomaSalvo = diplomaRepository.findById(diplomado_id);
        if (diplomaSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Extrai o diploma
        Diploma diploma = diplomaSalvo.get();

        // Busca o diplomado e o curso relacionados
        Optional<Diplomado> diplomadoOpt = diplomadoRepository.findById(diploma.getDiplomado().getId_diplomado());
        Optional<Curso> cursoOpt = cursoRepository.findById(diploma.getCurso().getId_curso());

        if (diplomadoOpt.isEmpty() || cursoOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Diplomado diplomado = diplomadoOpt.get();
        Curso curso = cursoOpt.get();

        // Constrói o DiplomaResponseDTO com os dados necessários
        DiplomaResponseDTO diplomaResponse = new DiplomaResponseDTO(
                diploma.getId_diploma(),
                diplomado,
                curso,
                diploma.getData_diploma(),
                diploma.getSexo_reitor(),
                diploma.getNome_reitor()
        );

        String textoDiploma = gerarTextoDiploma(diplomaResponse);
        return new ResponseEntity<>(textoDiploma, HttpStatus.OK);
    }


    @Operation(summary = "Registrar diploma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Diploma registrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos", content =  @Content(schema = @Schema()))
    })
    @PostMapping(value = "/gerar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiplomaResponseDTO> createDiploma(
            @Valid @RequestBody DiplomaRequestDTO diplomaRequest
    )
    {
        Diplomado diplomado = diplomadoRepository.findById(diplomaRequest.diplomado_id().getId_diplomado())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diplomado não encontrado"));


        Curso curso = cursoRepository.findById(diplomaRequest.curso_id().getId_curso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));


        Diploma diploma = new Diploma();
        diploma.setData_diploma(LocalDate.now());
        diploma.setNome_reitor(diplomaRequest.nome_reitor());
        diploma.setSexo_reitor(diplomaRequest.sexo_reitor());
        diploma.setCurso(curso);
        diploma.setDiplomado(diplomado);

        Diploma diplomaCriado = diplomaRepository.save(diploma);

        DiplomaResponseDTO diplomaResponseDTO = diplomaMapper.diplomaToResponseDTO(diplomaCriado);

        return new ResponseEntity<>(diplomaResponseDTO, HttpStatus.CREATED);
    }
}

