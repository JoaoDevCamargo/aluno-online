package aluno_online.repository;

import aluno_online.model.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaAlunoRepository
        extends JpaRepository<MatriculaAluno, Long> {
}