package cp2.java.gerenciador.de.diplomas.model;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) { this.role = role; }

    public String getRole() { return role; }
}
