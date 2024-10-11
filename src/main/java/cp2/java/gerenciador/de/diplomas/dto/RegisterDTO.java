package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.TipoUsuario;

public record RegisterDTO
        (
                String login, String senha, TipoUsuario tipoUsuario
        ) {
}
