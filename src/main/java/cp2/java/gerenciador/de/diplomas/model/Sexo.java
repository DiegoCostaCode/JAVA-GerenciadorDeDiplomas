package cp2.java.gerenciador.de.diplomas.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String sexo;

    Sexo(String sexo) {this.sexo = sexo;}

    @Override
    public String toString() {return sexo;}
}
