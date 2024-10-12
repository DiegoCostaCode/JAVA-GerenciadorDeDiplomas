package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.model.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DiplomaRequestDTO(
        @NotNull(message = "O diplomado é obrigatório!")
        Diplomado diplomado_id,
        @NotNull(message = "O curso é obrigatório!")
        Curso curso_id,
        @NotNull(message = "O sexo do reitor é obrigatório!")
        Sexo sexo_reitor,
        @NotBlank(message = "O nome do reitor é obrigatório!")
        String nome_reitor
        ) {
}
