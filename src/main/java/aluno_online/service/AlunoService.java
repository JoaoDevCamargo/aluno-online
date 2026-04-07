package aluno_online.service;

import aluno_online.model.Aluno;
import aluno_online.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoId(Long id) {
        return alunoRepository.findById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno alunoEditado) {
        alunoEditado.setId(id);
        alunoRepository.save(alunoEditado);
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

}
