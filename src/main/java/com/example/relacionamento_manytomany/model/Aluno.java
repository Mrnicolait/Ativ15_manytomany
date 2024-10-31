package com.example.relacionamento_manytomany.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "aluno_curso",
            joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id")
    )
    private Set<Curso> cursos = new HashSet<>();

    // Construtor com parâmetros para facilitar a criação de novos alunos
    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}

