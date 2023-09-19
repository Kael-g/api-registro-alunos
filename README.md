# API PARA REGISTRO DE ALUNOS
API desenvolvida para registro de alunos e turmas de uma escola. Seu principal diferencial é a forma humanizada de exibir os nomes dos alunos transgênero que utilizam nome social, de maneira que seu nome civil fique oculto e não haja nenhuma diferenciação dos demais nomes ao exibir seus dados ou a lista de alunos de uma turma.

## Linguagem e ferramentas
Java 11, Spring boot, Spring Web, Spring Data JPA, Lombok, Swagger, PostgreSQL.

Arquitetura MVC

## Principais classes e endpoints
### Aluno ( /alunos )
- **POST** - Registrar aluno com os seguintes atributos:
  - nome civil (obrigatório)
  - nome social (opcional)
  - sobrenome (obrigatório)
  - e-mail (obrigatório) 
  - CPF (obrigatório)
- **GET** - Exibir todos os alunos registrados com os atributos:
  - ID
  - nome de exibição (nome social + sobrenome caso possua nome social registrado ou nome civil + sobrenome caso contrário)
  - e-mail
  - CPF
- **GET** ( /{id} ) - Exibir aluno com o ID informado com os atributos:
    - ID
    - nome de exibição (nome social + sobrenome caso possua nome social registrado ou nome civil + sobrenome caso contrário)
    - e-mail
    - CPF
- **PUT** ( /{id} ) - Alterar informações do aluno com o ID informado
- **DELETE** ( /{id} ) - Deletar aluno com o ID informado

### Turma ( /turmas )
- **POST** - Registrar turma com os seguintes atributos:
    - nome (obrigatório)
    - lista de alunos (opcional)
- **GET** - Exibir todas as turmas registradas com os atributos:
    - ID
    - nome
    - quantidade de alunos matriculados
- **GET** ( /{id} ) - Exibir turma com o ID informado com os atributos:
  - ID
  - nome
  - lista de alunos seguindo o mesmo padrão para exibição de nomes citado anteriormente
- **PUT** ( /{id}/adicionar ) - adiciona aluno à turma com o ID informado
- **PUT** ( /{id}/remover ) - Remove aluno da turma com o ID informado
- **DELETE** ( /{id} ) - Deletar turma com o ID informado

## Bugs a corrigir e possíveis melhorias
- (corrigir) Não é possível deletar um aluno que está matriculado em uma turma
- (implementar) Possibilitar adicionar ou remover mais de um aluno por vez de uma turma
- (implementar) Melhorar Model de turmas, adicionando atributos de série, turma, turno e nível
- (implementar) Gerar lista de chamada de uma turma em ordem alfabética, considerando o nome social dos alunos que o utilizarem ao invés do nome civil