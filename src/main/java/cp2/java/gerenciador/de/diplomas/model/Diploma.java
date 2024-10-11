package cp2.java.gerenciador.de.diplomas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table( name = "TB_DIPLOMA")
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_diploma;
    @ManyToOne
    @JoinColumn(name = "diplomado_id")
    private Diplomado diplomado;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @Column(name = "data_diploma")
    private LocalDate data_diploma;
    @Column(name = "sexo_reitor_diploma")
    private Sexo sexo_reitor;
    @Column(name = "nome_reitor_diploma")
    private String nome_reitor;

    public UUID getId_diploma() {
        return id_diploma;
    }

    public void setId_diploma(UUID id_diploma) {
        this.id_diploma = id_diploma;
    }

    public Diplomado getDiplomado() {
        return diplomado;
    }

    public void setDiplomado(Diplomado diplomado) {
        this.diplomado = diplomado;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }


    public LocalDate getData_diploma() {
        return data_diploma;
    }

    public void setData_diploma(LocalDate data_diploma) {
        this.data_diploma = data_diploma;
    }

    public Sexo getSexo_reitor() {
        return sexo_reitor;
    }

    public void setSexo_reitor(Sexo sexo_reitor) {
        this.sexo_reitor = sexo_reitor;
    }

    public String getNome_reitor() {
        return nome_reitor;
    }

    public void setNome_reitor(String nome_reitor) {
        this.nome_reitor = nome_reitor;
    }
}
