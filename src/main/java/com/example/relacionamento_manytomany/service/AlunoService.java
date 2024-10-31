package com.example.relacionamento_manytomany.service;

import com.example.relacionamento_manytomany.model.Aluno;
import com.example.relacionamento_manytomany.model.Curso;
import com.example.relacionamento_manytomany.repository.AlunoRepository;
import com.example.relacionamento_manytomany.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;
@Transactional
    public Aluno getAlunoById (Long id) {
        Aluno aluno= alunoRepository.findByIdWithCursos(id).get();
        aluno.getCursos().size();
        return aluno;
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Curso> listarCursosPorAluno(Long alunoId) {
        return alunoRepository.findById(alunoId)
                .map(Aluno::getCursos)
                .map(List::copyOf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno matricularEmCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        aluno.getCursos().add(curso);
        return alunoRepository.save(aluno);
    }

    public Aluno desmatricularDeCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        aluno.getCursos().remove(curso);
        return alunoRepository.save(aluno);
    }
}

