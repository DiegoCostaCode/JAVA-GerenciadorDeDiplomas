package cp2.java.gerenciador.de.diplomas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DiplomaRequestDTO(
        @NotNull(message = "O diplomado é obrigatório!")
        Long diplomado_id,
        @NotNull(message = "O curso é obrigatório!")
        Long curso_id,
        @NotNull(message = "A data é obrigatória!")
        LocalDate data_diploma,
        @NotBlank(message = "O sexo do reitor é obrigatório!")
        String sexo_reitor,
        @NotBlank(message = "O nome do reitor é obrigatório!")
        String nome_reitor
        ) {


}
