package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.TipoCurso;

public record CursoResponseDTO(
        Long id_curso,
        String nome_curso,
        TipoCurso tipoCurso
) {
}
