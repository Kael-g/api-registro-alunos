package br.com.catalisa.registroAlunos.model.dto;

import br.com.catalisa.registroAlunos.model.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurmaCompletaDto {
    private Long id;
    private String nome;
    private List<AlunoExibicaoDto> alunos;

    public TurmaCompletaDto(TurmaModel turmaModel, List<AlunoExibicaoDto> alunos) {
        this.id = turmaModel.getIdTurma();
        this.nome = turmaModel.getNome();
        this.alunos = alunos;
    }
}
