package br.com.catalisa.registroAlunos.service;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import br.com.catalisa.registroAlunos.model.dto.AlunoExibicaoDto;
import br.com.catalisa.registroAlunos.model.dto.AlunoSalvoDto;
import br.com.catalisa.registroAlunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public AlunoSalvoDto novoAluno(AlunoModel alunoModel){
        return new AlunoSalvoDto(alunoRepository.save(alunoModel), gerarNomeExibicao(alunoModel));
    }

    public List<AlunoExibicaoDto> exibirTodosAlunos(){
        List<AlunoModel> alunosModel = alunoRepository.findAll();
        List<AlunoExibicaoDto> alunosExibicao = new ArrayList<>();

        for (AlunoModel a : alunosModel){
            alunosExibicao.add(new AlunoExibicaoDto(a, gerarNomeExibicao(a)));
        }

        return alunosExibicao;
    }

    public Optional<AlunoExibicaoDto> exibirAlunoPorId(Long id){
        Optional<AlunoExibicaoDto> alunoExibicaoDto = Optional.empty();
        Optional<AlunoModel> alunoModel = alunoRepository.findById(id);

        if (alunoModel.isPresent()){
            alunoExibicaoDto = Optional.of(new AlunoExibicaoDto(alunoModel.get(), gerarNomeExibicao(alunoModel.get())));
        }

        return alunoExibicaoDto;
    }

    public AlunoSalvoDto alterarAluno(Long id, AlunoModel alunoAlterar){
        AlunoModel alunoModel = alunoRepository.findById(id).get();

        if (alunoAlterar.getNomeCivil() != null){
            alunoModel.setNomeCivil(alunoAlterar.getNomeCivil());
        }
        if (alunoAlterar.getNomeSocial() != null){
            alunoModel.setNomeSocial(alunoAlterar.getNomeSocial());
        }
        if (alunoAlterar.getSobrenome() != null){
            alunoModel.setSobrenome(alunoAlterar.getSobrenome());
        }
        if (alunoAlterar.getEmail() != null){
            alunoModel.setEmail(alunoAlterar.getEmail());
        }
        if (alunoAlterar.getCpf() != null){
            alunoModel.setCpf(alunoAlterar.getCpf());
        }

        return new AlunoSalvoDto(alunoRepository.save(alunoModel), gerarNomeExibicao(alunoModel));
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public String gerarNomeExibicao(AlunoModel alunoModel){
        String nomeExibicao;
        if (alunoModel.getNomeSocial() != null){
            nomeExibicao = alunoModel.getNomeSocial() + " " + alunoModel.getSobrenome();
        } else {
            nomeExibicao = alunoModel.getNomeCivil() + " " + alunoModel.getSobrenome();
        }
        return nomeExibicao;
    }
}
