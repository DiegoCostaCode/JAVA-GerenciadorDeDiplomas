package cp2.java.gerenciador.de.diplomas.repository;

import cp2.java.gerenciador.de.diplomas.model.Diploma;
import cp2.java.gerenciador.de.diplomas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);
}
