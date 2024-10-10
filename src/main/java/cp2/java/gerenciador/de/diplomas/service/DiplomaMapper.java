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

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    public Diploma requestRecordToDiploma(DiplomaRequestDTO diplomaRequestDTO) {
        Diploma diploma = new Diploma();

        Diplomado diplomado = diplomadoRepository.findById(diplomaRequestDTO.diplomado_id())
                .orElseThrow(() -> new RuntimeException("Diplomado não encontrado."));
        Curso curso = cursoRepository.findById(diplomaRequestDTO.curso_id())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        diploma.setDiplomado_id(diplomado);
        diploma.setCurso_id(curso);
        diploma.setData_diploma(diplomaRequestDTO.data_diploma());
        diploma.setSexo_reitor(Sexo.valueOf(diplomaRequestDTO.sexo_reitor().toUpperCase()));
        diploma.setNome_reitor(diplomaRequestDTO.nome_reitor());
        return diploma;
    }

    public DiplomaResponseDTO diplomaToResponseDTO(Diploma diploma, Diplomado diplomado, Curso curso, Sexo sexo) {
        return new DiplomaResponseDTO(
                diploma.getId_diploma(),
                diploma.getDiplomado_id(),
                diploma.getCurso_id(),
                diploma.getData_diploma(),
                diploma.getSexo_reitor(),
                diploma.getNome_reitor()
        );
    }

}
