package aluno_online.controller;

import aluno_online.dtos.AtualizarNotasRequestDTO;
import aluno_online.model.MatriculaAluno;
import aluno_online.service.MatriculaAlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaAlunoController {

    @Autowired
    private MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatriculaAluno criar(@RequestBody MatriculaAluno matricula) {
        return service.criar(matricula);
    }

    @PatchMapping("/trancar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void trancar(@PathVariable Long id) {
        service.trancar(id);
    }

    @PatchMapping("/notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarNotas(
            @PathVariable Long id,
            @RequestBody AtualizarNotasRequestDTO dto
    ) {
        service.atualizarNotas(id, dto);
    }

    @GetMapping
    public java.util.List<MatriculaAluno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public MatriculaAluno buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}