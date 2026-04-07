package aluno_online.controller;

import aluno_online.model.Aluno;
import aluno_online.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@RequestBody Aluno aluno) {
        alunoService.criarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable Long id, @RequestBody Aluno alunoEditado) {
        alunoService.atualizarAlunoPorId(id, alunoEditado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
    }
}