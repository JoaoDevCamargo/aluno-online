package aluno_online.service;

import aluno_online.dtos.AtualizarNotasRequestDTO;
import aluno_online.model.MatriculaAluno;
import aluno_online.repository.MatriculaAlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaAlunoService {

    @Autowired
    private MatriculaAlunoRepository repository;

    private static final Double MEDIA_PARA_APROVACAO = 7.0;

    public MatriculaAluno criar(MatriculaAluno matricula) {
        return repository.save(matricula);
    }

    public List<MatriculaAluno> listar() {
        return repository.findAll();
    }

    public MatriculaAluno buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Matrícula não encontrada"
                ));
    }

    public void trancar(Long id) {

        MatriculaAluno matricula = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Matrícula não encontrada"
                ));

        matricula.setStatus("TRANCADO");

        repository.save(matricula);
    }

    public void atualizarNotas(Long id, AtualizarNotasRequestDTO dto) {

        MatriculaAluno matricula = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Matrícula não encontrada"
                ));

        System.out.println("ANTES:");
        System.out.println(matricula);

        if (dto.getNota1() != null) {
            matricula.setNota1(dto.getNota1());
        }

        if (dto.getNota2() != null) {
            matricula.setNota2(dto.getNota2());
        }

        if (matricula.getNota1() != null &&
                matricula.getNota2() != null) {

            double media =
                    (matricula.getNota1() + matricula.getNota2()) / 2;

            matricula.setStatus(
                    media >= MEDIA_PARA_APROVACAO
                            ? "APROVADO"
                            : "REPROVADO"
            );
        }

        repository.save(matricula);

        System.out.println("DEPOIS:");
        System.out.println(matricula);

    }
}