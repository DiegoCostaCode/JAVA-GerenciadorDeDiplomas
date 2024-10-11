package cp2.java.gerenciador.de.diplomas.dto;

import cp2.java.gerenciador.de.diplomas.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {}
