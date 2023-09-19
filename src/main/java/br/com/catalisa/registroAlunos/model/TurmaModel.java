package br.com.catalisa.registroAlunos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "TB_TURMAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @NotBlank(message = "Nome da turma é obrigatório")
    @Column(unique = true)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_TURMAS_ALUNOS", joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    private List<AlunoModel> alunos;
}
