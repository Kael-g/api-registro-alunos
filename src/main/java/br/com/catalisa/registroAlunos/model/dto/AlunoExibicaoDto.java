package br.com.catalisa.registroAlunos.model.dto;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoExibicaoDto {
    private Long idAluno;
    private String nomeExibicao;
    private String email;
    private String cpf;

    public AlunoExibicaoDto(AlunoModel alunoModel, String nomeExibicao) {
        this.idAluno = alunoModel.getIdAluno();
        this.nomeExibicao = nomeExibicao;
        this.email = alunoModel.getEmail();
        this.cpf = alunoModel.getCpf();
    }
}
