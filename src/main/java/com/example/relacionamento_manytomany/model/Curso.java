package com.example.relacionamento_manytomany.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();

    // Construtor com parâmetros para facilitar a criação de novos cursos
    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}




