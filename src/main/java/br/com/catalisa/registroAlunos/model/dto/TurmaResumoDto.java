package br.com.catalisa.registroAlunos.model.dto;

import br.com.catalisa.registroAlunos.model.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResumoDto {
    private Long id;
    private String nome;
    private Integer qtdAlunos;

    public TurmaResumoDto(TurmaModel turmaModel) {
        this.id = turmaModel.getIdTurma();
        this.nome = turmaModel.getNome();
        this.qtdAlunos = turmaModel.getAlunos().size();
    }
}
