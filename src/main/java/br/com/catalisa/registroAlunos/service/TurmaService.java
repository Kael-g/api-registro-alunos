package br.com.catalisa.registroAlunos.service;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import br.com.catalisa.registroAlunos.model.TurmaModel;
import br.com.catalisa.registroAlunos.model.dto.AlunoExibicaoDto;
import br.com.catalisa.registroAlunos.model.dto.TurmaCompletaDto;
import br.com.catalisa.registroAlunos.model.dto.TurmaResumoDto;
import br.com.catalisa.registroAlunos.repository.AlunoRepository;
import br.com.catalisa.registroAlunos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    AlunoService alunoService;
    @Autowired
    AlunoRepository alunoRepository;

    public TurmaCompletaDto novaTurma(TurmaModel turmaModel) {
        List<AlunoModel> alunos = new ArrayList<>();
        for (AlunoModel alunoModel : turmaModel.getAlunos()){
            alunos.add(alunoRepository.findById(alunoModel.getIdAluno()).get());
        }
        turmaModel.setAlunos(alunos);
        return new TurmaCompletaDto(turmaRepository.save(turmaModel), listaAlunosModelParaAlunosExibicao(alunos));
    }

    public List<TurmaResumoDto> exibirTurmas() {
        List<TurmaResumoDto> turmas = new ArrayList<>();

        for (TurmaModel turma : turmaRepository.findAll()){
            turmas.add(new TurmaResumoDto(turma));
        }

        return turmas;
    }

    public Optional<TurmaCompletaDto> exibirTurmaPorId(Long id) {
        Optional<TurmaCompletaDto> turmaCompletaDto = Optional.empty();
        Optional<TurmaModel> turmaModel = turmaRepository.findById(id);

        if (turmaModel.isPresent()){
            turmaCompletaDto = Optional.of(new TurmaCompletaDto(turmaModel.get(), listaAlunosModelParaAlunosExibicao(turmaModel.get().getAlunos())));
        }

        return turmaCompletaDto;
    }

    public List<AlunoExibicaoDto> adicionarAlunos(Long id, AlunoModel alunoModel) {
        TurmaModel turmaModel = turmaRepository.findById(id).get();
        List<AlunoModel> alunos = turmaModel.getAlunos();
        AlunoModel encontrarAluno = alunoRepository.findById(alunoModel.getIdAluno()).get();
        alunos.add(encontrarAluno);
        turmaModel.setAlunos(alunos);
        try{
            return listaAlunosModelParaAlunosExibicao(turmaRepository.save(turmaModel).getAlunos());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<AlunoExibicaoDto> removerAluno(Long id, AlunoModel alunoModel) {
        TurmaModel turmaModel = turmaRepository.findById(id).get();
        List<AlunoModel> alunos = turmaModel.getAlunos();
        try{
            AlunoModel encontrarAluno = alunoRepository.findById(alunoModel.getIdAluno()).get();
            alunos.remove(encontrarAluno);
            turmaModel.setAlunos(alunos);
            return listaAlunosModelParaAlunosExibicao(turmaRepository.save(turmaModel).getAlunos());
        } catch (Exception e){
            throw new IllegalArgumentException("Aluno não encontrado");
        }
    }

    public void deletarTurma(Long id) {
        turmaRepository.deleteById(id);
    }

    private List<AlunoExibicaoDto> listaAlunosModelParaAlunosExibicao(List<AlunoModel> alunosModel){
        List<AlunoExibicaoDto> alunosExibicao = new ArrayList<>();

        for (AlunoModel alunoModel : alunosModel){
            alunosExibicao.add(new AlunoExibicaoDto(alunoModel, alunoService.gerarNomeExibicao(alunoModel)));
        }

        return alunosExibicao;
    }
}
