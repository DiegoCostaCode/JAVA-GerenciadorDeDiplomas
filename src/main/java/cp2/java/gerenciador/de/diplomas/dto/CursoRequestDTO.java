package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.TipoCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequestDTO(
        @NotBlank(message = "O nome do curso é obrigatório!")
        String nome_curso,
        @NotNull(message = "O tipo do curso é obrigatório!")
        TipoCurso tipo_curso
) {
}
