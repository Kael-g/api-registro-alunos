package br.com.catalisa.registroAlunos.controller;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import br.com.catalisa.registroAlunos.model.dto.AlunoExibicaoDto;
import br.com.catalisa.registroAlunos.model.dto.AlunoSalvoDto;
import br.com.catalisa.registroAlunos.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos", produces = {"application/json"})
@Tag(name = "Registro Alunos")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar novo aluno", method = "POST")
    public ResponseEntity<AlunoSalvoDto> novoAluno(@RequestBody @Valid AlunoModel alunoModel){
        return new ResponseEntity<>(alunoService.novoAluno(alunoModel), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os alunos", method = "GET")
    public ResponseEntity<List<AlunoExibicaoDto>> exibirTodosAlunos(){
        return ResponseEntity.ok(alunoService.exibirTodosAlunos());
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Buscar um aluno por ID", method = "GET")
    public ResponseEntity<?> exibirAlunoPorId(@PathVariable Long id){
        Optional<AlunoExibicaoDto> aluno = alunoService.exibirAlunoPorId(id);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        return ResponseEntity.ok(aluno.get());
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Alterar aluno", method = "PUT")
    public AlunoSalvoDto alterarAluno(@PathVariable Long id, @RequestBody AlunoModel alunoModel){
        return alunoService.alterarAluno(id, alunoModel);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deletar aluno", method = "DELETE")
    public void deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }
}
