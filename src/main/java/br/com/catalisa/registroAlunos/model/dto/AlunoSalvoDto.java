package br.com.catalisa.registroAlunos.model.dto;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoSalvoDto {
    private Long idAluno;
    private String nomeCivil;
    private String nomeSocial;
    private String sobrenome;
    private String nomeExibicao;
    private String email;
    private String cpf;

    public AlunoSalvoDto(AlunoModel alunoModel, String nomeExibicao) {
        this.idAluno = alunoModel.getIdAluno();
        this.nomeCivil = alunoModel.getNomeCivil();
        this.nomeSocial = alunoModel.getNomeSocial();
        this.sobrenome = alunoModel.getSobrenome();
        this.nomeExibicao = nomeExibicao;
        this.email = alunoModel.getEmail();
        this.cpf = alunoModel.getCpf();
    }
}
