package cp2.java.gerenciador.de.diplomas.dto;

public record DiplomadoResponseDTO(
        Long id,
        String nome_diplomado,
        String nacionalidade_diplomado,
        String naturalidade_diplomado,
        Long rg_diplomado
) {
}
