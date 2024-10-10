package cp2.java.gerenciador.de.diplomas.model;

public enum TipoCurso {
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós-Graduação");
    private String tipo;

    TipoCurso(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
