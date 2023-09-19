package br.com.catalisa.registroAlunos.controller;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import br.com.catalisa.registroAlunos.model.TurmaModel;
import br.com.catalisa.registroAlunos.model.dto.AlunoExibicaoDto;
import br.com.catalisa.registroAlunos.model.dto.TurmaCompletaDto;
import br.com.catalisa.registroAlunos.model.dto.TurmaResumoDto;
import br.com.catalisa.registroAlunos.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/turmas", produces = {"application/json"})
@Tag(name = "Registro Alunos")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria nova turma", method = "POST")
    public ResponseEntity<TurmaCompletaDto> novaTurma(@RequestBody TurmaModel turmaModel){
        return new ResponseEntity<>(turmaService.novaTurma(turmaModel), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Exibe versão resumida de todas as turmas", method = "GET")
    public ResponseEntity<List<TurmaResumoDto>> exibirTurmas(){
        return ResponseEntity.ok(turmaService.exibirTurmas());
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Exibe uma turma por ID com todos os seus alunos", method = "GET")
    public ResponseEntity<?> exibirTurmaPorId(@PathVariable Long id){
        Optional<TurmaCompletaDto> turma = turmaService.exibirTurmaPorId(id);
        if (turma.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada!");
        }
        return ResponseEntity.ok(turma.get());
    }

    @PutMapping(path = "/{id}/adicionar", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Adiciona aluno a uma turma", method = "PUT")
    public List<AlunoExibicaoDto> adicionarAlunos(@PathVariable Long id, @RequestBody AlunoModel alunoModel){
        return turmaService.adicionarAlunos(id, alunoModel);
    }

    @PutMapping(path = "/{id}/remover", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Remove aluno da turma", method = "PUT")
    public List<AlunoExibicaoDto> removerAlunos(@PathVariable Long id, @RequestBody AlunoModel alunoModel){
        return turmaService.removerAluno(id, alunoModel);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deleta turma", method = "DELETE")
    public void deletarTurma(@PathVariable Long id){
        turmaService.deletarTurma(id);
    }

}
