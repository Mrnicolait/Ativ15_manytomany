package com.example.relacionamento_manytomany.controller;

import com.example.relacionamento_manytomany.model.Curso;
import com.example.relacionamento_manytomany.model.Aluno;
import com.example.relacionamento_manytomany.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.salvarCurso(curso);
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> listarAlunosPorCurso(@PathVariable Long id) {
        return cursoService.listarAlunosPorCurso(id);
    }
}

