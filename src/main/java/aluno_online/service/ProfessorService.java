package aluno_online.service;

import aluno_online.model.Professor;
import aluno_online.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void criarProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> listarTodosProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessorPorId(Long id) {
        return professorRepository.findById(id);
    }

    public void atualizarProfessorPorId(Long id, Professor professorEditado) {
        professorEditado.setId(id);
        professorRepository.save(professorEditado);
    }

    public void deletarProfessorPorId(Long id) {
        professorRepository.deleteById(id);
    }
}