package cp2.java.gerenciador.de.diplomas.repository;

import cp2.java.gerenciador.de.diplomas.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepository extends JpaRepository<Curso, Long> {
}
