package com.example.relacionamento_manytomany.repository;

import com.example.relacionamento_manytomany.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);
    @Query("SELECT a FROM Aluno a LEFT JOIN a.cursos WHERE a.id = :id")
    Optional<Aluno> findByIdWithCursos(@Param("id") Long id);
}
