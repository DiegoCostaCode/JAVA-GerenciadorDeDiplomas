package cp2.java.gerenciador.de.diplomas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    @Column(name = "nome_curso")
    private String nome_curso;
    @Column(name = "tipo_curso")
    private TipoCurso tipo_curso;

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public TipoCurso getTipo_curso() {
        return tipo_curso;
    }

    public void setTipo_curso(TipoCurso tipo_curso) {
        this.tipo_curso = tipo_curso;
    }
}
