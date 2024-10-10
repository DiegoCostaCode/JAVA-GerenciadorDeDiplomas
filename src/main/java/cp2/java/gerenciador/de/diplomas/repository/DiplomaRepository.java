package cp2.java.gerenciador.de.diplomas.repository;

import cp2.java.gerenciador.de.diplomas.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiplomaRepository  extends JpaRepository<Diploma, UUID> {
}
