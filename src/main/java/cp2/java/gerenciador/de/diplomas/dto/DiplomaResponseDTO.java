package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.model.Sexo;

import java.time.LocalDate;
import java.util.UUID;

public record DiplomaResponseDTO(
        UUID id_diploma,
        Diplomado diplomado_id,
        Curso curso_id,
        LocalDate data_diploma,
        Sexo sexo_reitor,
        String nome_reitor
) {


}
