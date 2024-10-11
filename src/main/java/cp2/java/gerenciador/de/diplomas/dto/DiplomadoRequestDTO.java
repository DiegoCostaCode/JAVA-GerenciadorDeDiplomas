package cp2.java.gerenciador.de.diplomas.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DiplomadoRequestDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome_diplomado,
        @NotBlank(message = "A nacionalidade é obrigatória!")
        String nacionalidade_diplomado,
        @NotBlank(message = "A naturalidade é obrigatória!")
        String naturalidade_diplomado,
        @NotBlank(message = "O rg do reitor é obrigatório!")
        String rg_diplomado
) {
}
