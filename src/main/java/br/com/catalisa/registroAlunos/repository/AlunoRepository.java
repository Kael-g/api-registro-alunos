package br.com.catalisa.registroAlunos.repository;

import br.com.catalisa.registroAlunos.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
