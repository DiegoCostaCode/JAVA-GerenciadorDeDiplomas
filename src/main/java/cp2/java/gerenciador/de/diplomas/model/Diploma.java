package cp2.java.gerenciador.de.diplomas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table( name = "TB_DIPLOMA")
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_diploma;
    @ManyToOne
    @JoinColumn(name = "diplomado_id")
    private Diplomado diplomado_id;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso_id;
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

    public Diplomado getDiplomado_id() {
        return diplomado_id;
    }

    public void setDiplomado_id(Diplomado diplomado_id) {
        this.diplomado_id = diplomado_id;
    }

    public Curso getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Curso curso_id) {
        this.curso_id = curso_id;
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
