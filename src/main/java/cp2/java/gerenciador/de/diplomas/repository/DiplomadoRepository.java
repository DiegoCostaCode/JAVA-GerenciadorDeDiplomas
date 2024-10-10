package cp2.java.gerenciador.de.diplomas.repository;

import cp2.java.gerenciador.de.diplomas.model.Diplomado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomadoRepository extends JpaRepository<Diplomado, Long> {
}
