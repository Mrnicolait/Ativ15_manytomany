package com.example.relacionamento_manytomany.service;

import com.example.relacionamento_manytomany.model.Curso;
import com.example.relacionamento_manytomany.model.Aluno;
import com.example.relacionamento_manytomany.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Aluno> listarAlunosPorCurso(Long cursoId) {
        return cursoRepository.findById(cursoId)
                .map(Curso::getAlunos)
                .map(List::copyOf)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}
