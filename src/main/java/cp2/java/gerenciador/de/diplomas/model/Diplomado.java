package cp2.java.gerenciador.de.diplomas.model;

import jakarta.persistence.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "TB_DIPLOMADO")
public class Diplomado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_diplomado;
    @Column(name = "nome_diplomado")
    private String nome_diplomado;
    @Column(name = "nacionalidade_diplomado")
    private String nacionalidade_diplomado;
    @Column(name = "naturalidade_diplomado")
    private String naturalidade_diplomado;
    @Column(name = "rg_diplomado")
    private Long rg_diplomado;

    public Long getId_diplomado() {
        return id_diplomado;
    }

    public void setId_diplomado(Long id_diplomado) {
        this.id_diplomado = id_diplomado;
    }

    public String getNome_diplomado() {
        return nome_diplomado;
    }

    public void setNome_diplomado(String nome_diplomado) {
        this.nome_diplomado = nome_diplomado;
    }

    public String getNacionalidade_diplomado() {
        return nacionalidade_diplomado;
    }

    public void setNacionalidade_diplomado(String nacionalidade_diplomado) {
        this.nacionalidade_diplomado = nacionalidade_diplomado;
    }

    public String getNaturalidade_diplomado() {
        return naturalidade_diplomado;
    }

    public void setNaturalidade_diplomado(String naturalidade_diplomado) {
        this.naturalidade_diplomado = naturalidade_diplomado;
    }

    public Long getRg_diplomado() {
        return rg_diplomado;
    }

    public void setRg_diplomado(Long rg_diplomado) {
        this.rg_diplomado = rg_diplomado;
    }
}
