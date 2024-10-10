package cp2.java.gerenciador.de.diplomas.service;

import cp2.java.gerenciador.de.diplomas.dto.DiplomadoRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomadoResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import org.springframework.stereotype.Service;

@Service
public class DiplomadoMapper {

    public Diplomado requestRecordToDiplomado(DiplomadoRequestDTO diplomadoRequestDTO) {
        Diplomado diplomado = new Diplomado();

        diplomado.setNome_diplomado(diplomadoRequestDTO.nome_diplomado());
        diplomado.setNacionalidade_diplomado(diplomadoRequestDTO.nacionalidade_diplomado());
        diplomado.setNaturalidade_diplomado(diplomadoRequestDTO.nacionalidade_diplomado());
        diplomado.setRg_diplomado(diplomadoRequestDTO.rg_diplomado());
        return diplomado;
    }

    public DiplomadoResponseDTO diplomadoToResponseDTO(Diplomado diplomado) {
        return new DiplomadoResponseDTO(
                diplomado.getId_diplomado(),
                diplomado.getNome_diplomado(),
                diplomado.getNacionalidade_diplomado(),
                diplomado.getNaturalidade_diplomado(),
                diplomado.getRg_diplomado()
        );
    }

}
