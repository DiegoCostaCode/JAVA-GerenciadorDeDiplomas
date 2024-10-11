package cp2.java.gerenciador.de.diplomas.service;

import cp2.java.gerenciador.de.diplomas.dto.DiplomaRequestDTO;
import cp2.java.gerenciador.de.diplomas.dto.DiplomaResponseDTO;
import cp2.java.gerenciador.de.diplomas.model.Curso;
import cp2.java.gerenciador.de.diplomas.model.Diploma;
import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import cp2.java.gerenciador.de.diplomas.model.Sexo;
import cp2.java.gerenciador.de.diplomas.repository.CursoRepository;
import cp2.java.gerenciador.de.diplomas.repository.DiplomadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomaMapper {


    public Diploma requestRecordToDiploma(DiplomaRequestDTO diplomaRequestDTO) {
        Diploma diploma = new Diploma();

        diploma.setDiplomado(diplomaRequestDTO.diplomado_id());
        diploma.setCurso(diplomaRequestDTO.curso_id());
        diploma.setData_diploma(diplomaRequestDTO.data_diploma());
        diploma.setSexo_reitor(diplomaRequestDTO.sexo_reitor());
        diploma.setNome_reitor(diplomaRequestDTO.nome_reitor());
        return diploma;
    }

    public DiplomaResponseDTO diplomaToResponseDTO(Diploma diploma) {

//        Diplomado diplomado = diploma.getDiplomado();
//        Curso curso = diploma.getCurso();
//
//        // Gerando o título e cargo do reitor baseado no sexo
//        String tituloReitor = diploma.getSexo_reitor() == Sexo.FEMININO ? "Prof. Dr. " : "Profa. Dra. ";
//        tituloReitor += diploma.getNome_reitor();
//        String cargoReitor = diploma.getSexo_reitor() == Sexo.MASCULINO ? "reitor" : "reitora";


        return new DiplomaResponseDTO(
                diploma.getId_diploma(),
                diploma.getDiplomado(),
                diploma.getCurso(),
                diploma.getData_diploma(),
                diploma.getSexo_reitor(),
                diploma.getNome_reitor()
        );
    }

}
