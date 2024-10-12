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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired(required = true)
    private CursoMapper cursoMapper;


    @PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CursoResponseDTO> createCurso(@Valid @RequestBody CursoRequestDTO cursoRequest)
    {
        Curso cursoSalvo = cursoMapper.requestRecordToCurso(cursoRequest);
        Curso cursoCriado = cursoRepository.save(cursoSalvo);

        CursoResponseDTO cursoResponseDTO = cursoMapper.cursoToResponseDTO(cursoCriado);
        return new ResponseEntity<>(cursoResponseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Curso>> readCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        if (cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{curso_id}")
    public ResponseEntity<Void> atualizarCurso(@PathVariable Long curso_id, @Valid @RequestBody CursoRequestDTO cursoRequest) {
        Curso curso = cursoRepository.findById(curso_id).orElse(null);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        curso.setNome_curso(cursoRequest.nome_curso());
        curso.setTipo_curso(cursoRequest.tipo_curso());
        cursoRepository.save(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{curso_id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long curso_id) {
        Curso curso = cursoRepository.findById(curso_id).orElse(null);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cursoRepository.delete(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
