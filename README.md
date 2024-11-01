Atividade 15 - Implementando Relacionamento ManyToMany

Objetivo: Desenvolver uma aplicação em Spring Boot que implemente um relacionamento Many-to-Many entre duas entidades, Aluno e Curso, com as operações básicas de CRUD e listagem. Ao final, a aplicação deverá permitir que um aluno esteja matriculado em vários cursos e um curso tenha vários alunos matriculados.
Cenário: Uma escola está implementando um sistema para gerenciar as matrículas de alunos em diversos cursos. Para isso, você deve criar duas entidades principais:

    Aluno:
        Atributos: id (Long), nome (String), email (String).
        Cada aluno pode estar matriculado em vários cursos.

    Curso:
        Atributos: id (Long), nome (String), descricao (String).
        Cada curso pode ter vários alunos matriculados.

Para este relacionamento, utilize o padrão @ManyToMany do JPA, criando uma tabela intermediária que vincule alunos e cursos.
Requisitos

    Modelagem do Banco de Dados: Configure o relacionamento Many-to-Many entre as entidades Aluno e Curso, de modo que o JPA crie uma tabela de junção automaticamente.

    Entidades JPA:
        Configure o relacionamento utilizando a anotação @ManyToMany nas classes de entidade.
        Utilize @JoinTable para definir a tabela de junção, juntamente com @JoinColumn para especificar as colunas de chave estrangeira.

    Repositórios: Crie repositórios para as entidades Aluno e Curso para realizar operações CRUD e consultas.

    Serviço: Implemente um serviço que permita:
            Criar novos alunos e cursos.
            Adicionar e remover um aluno de um curso específico.
            Listar todos os cursos de um aluno e todos os alunos de um curso.

    Controller: Implemente um controlador REST para as seguintes operações:
            POST /alunos: Adicionar um novo aluno.
            POST /cursos: Adicionar um novo curso.
            POST /alunos/{id}/cursos/{cursoId}: Matricular um aluno em um curso.
            DELETE /alunos/{id}/cursos/{cursoId}: Remover um aluno de um curso.
            GET /alunos/{id}/cursos: Listar todos os cursos em que um aluno está matriculado.

            GET /cursos/{id}/alunos: Listar todos os alunos matriculados em um curso.


Desafio Adicional (Opcional): Implemente uma funcionalidade que permita pesquisar cursos por nome e alunos por e-mail, utilizando 
consultas dinâmicas no repositório.
