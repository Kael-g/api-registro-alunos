package br.com.catalisa.registroAlunos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoChamadaDto {
    private Long id;
    private String nomeExibicao;
}
