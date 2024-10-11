package cp2.java.gerenciador.de.diplomas.service;


import cp2.java.gerenciador.de.diplomas.dto.CursoRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.CursoResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.TipoCurso;
import org.springframework.stereotype.Service;

@Service
public class CursoMapper {

    public Curso requestRecordToCurso(CursoRequestDTO cursoRequestDTO) {
        Curso curso = new Curso();
        curso.setNome_curso(cursoRequestDTO.nome_curso());
        curso.setTipo_curso(cursoRequestDTO.tipo_curso());
        return curso;
    }

    public CursoResponseDTO cursoToResponseDTO(Curso curso) {
        return new CursoResponseDTO(
                curso.getId_curso(),
                curso.getNome_curso(),
                curso.getTipo_curso()
        );
    }

}
