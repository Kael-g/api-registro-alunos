package br.com.catalisa.registroAlunos.repository;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import br.com.catalisa.registroAlunos.model.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {
//    @Query(value = "SELECT id_aluno FROM tb_turmas_alunos WHERE id_turma = ?1", nativeQuery = true)
//    List<Long> findByIdTurma(Long id);
}
