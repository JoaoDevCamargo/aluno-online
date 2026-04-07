package aluno_online.controller;

import aluno_online.model.Professor;
import aluno_online.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProfessor(@RequestBody Professor professor) {
        professorService.criarProfessor(professor);
    }

    @GetMapping
    public List<Professor> listarTodosProfessores() {
        return professorService.listarTodosProfessores();
    }

    @GetMapping("/{id}")
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessorPorId(@PathVariable Long id, @RequestBody Professor professorEditado) {
        professorService.atualizarProfessorPorId(id, professorEditado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessorPorId(@PathVariable Long id) {
        professorService.deletarProfessorPorId(id);
    }
}