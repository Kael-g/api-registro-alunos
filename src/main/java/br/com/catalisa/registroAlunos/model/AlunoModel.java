package br.com.catalisa.registroAlunos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_ALUNOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(nullable = false)
    @NotBlank(message = "Nome civil é obrigatório")
    private String nomeCivil;

    private String nomeSocial;

    @Column(nullable = false)
    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Column(nullable = false, unique = true)
    @CPF
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
}
