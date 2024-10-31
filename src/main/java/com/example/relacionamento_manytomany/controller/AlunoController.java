package com.example.relacionamento_manytomany.controller;

import com.example.relacionamento_manytomany.model.Aluno;
import com.example.relacionamento_manytomany.model.Curso;
import com.example.relacionamento_manytomany.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Long id){
        return alunoService.getAlunoById(id);
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @PostMapping("/{id}/cursos/{cursoId}")
    public Aluno matricularAlunoEmCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        return alunoService.matricularEmCurso(id, cursoId);
    }

    @DeleteMapping("/{id}/cursos/{cursoId}")
    public Aluno desmatricularAlunoDeCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        return alunoService.desmatricularDeCurso(id, cursoId);
    }

    @GetMapping("/{id}/cursos")
    public List<Curso> listarCursosPorAluno(@PathVariable Long id) {
        return alunoService.listarCursosPorAluno(id);
    }
}

