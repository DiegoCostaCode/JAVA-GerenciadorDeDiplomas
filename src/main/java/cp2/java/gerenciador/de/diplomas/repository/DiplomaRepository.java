package cp2.java.gerenciador.de.diplomas.repository;

import cp2.java.gerenciador.de.diplomas.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DiplomaRepository extends JpaRepository<Diploma, UUID> {
}
