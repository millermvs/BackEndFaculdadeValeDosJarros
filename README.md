# Faculdade Vale dos Jarros - Sistema Acadêmico (Backend)

Este projeto é um backend em **Spring Boot 3.5.7** com **Java 21**, modelando os principais elementos de uma faculdade fictícia chamada *Faculdade Vale dos Jarros*, conforme o minimundo proposto.

O sistema está sendo desenvolvido com foco em:

- Arquitetura limpa  
- Modelagem de domínio correta  
- Relacionamentos JPA bem estruturados  
- DTOs isolando entidades  
- Boas práticas de Service, Repository e Controller  
- Uso consistente de LAZY, EntityGraph e exceções customizadas  

---

# 📦 Estrutura do Projeto

```
application/        -> Controllers (entrada da API)
domain/
  dtos/             -> DTOs de request e response
  entities/         -> Entidades JPA
  exceptions/       -> Exceções customizadas
  handlers/         -> GlobalExceptionHandler
  services/         -> Regras de negócio
infrastructure/
  repositories/     -> Interfaces JPA
```

---

# 🧠 Modelagem Implementada Até Agora

## 🏢 Departamento
- Cada departamento pode ter vários cursos.
- Cada departamento pode ter vários professores.
- Relacionamentos:
  - **1:N com Curso**
  - **1:N com Professor** (usando `Set` para evitar duplicidade)
- Entidade mantém:
  ```java
  @OneToMany(mappedBy = "departamento")
  private Set<Professor> professores;
  ```

---

## 👨‍🏫 Professor
- Cada professor pertence a exatamente um departamento.
- Relacionamento:
  - **N:1 com Departamento**
- Implementações importantes:
  - Nome formatado com inicial maiúscula no cadastro.
  - Serviço sincroniza os dois lados da relação:
    - `professor.setDepartamento(dep)`
    - `dep.getProfessores().add(professor)`
  - Repositório com `@EntityGraph` para carregar departamento junto.

Endpoint principal:
```
POST /api/v1/professores/cadastrar
```

---

## 🎓 Curso
- Cada curso pertence a um departamento.
- Cada curso possui várias disciplinas.
- Relacionamentos:
  - **N:1 com Departamento**
  - **1:N com Disciplina**

---

## 📘 Disciplina
- Cada disciplina pertence a um curso.
- Cada disciplina possui várias turmas.
- Relacionamentos:
  - **N:1 com Curso**
  - **1:N com Turma**

---

## 👥 Turma
- Cada turma pertence a uma disciplina.
- Relacionamento:
  - **N:1 com Disciplina**

Endpoint principal:
```
POST /api/v1/turmas/cadastrar
```

---

# 🔧 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Hibernate EntityGraph**
- **Lombok**
- **DTO Pattern**
- **Arquitetura em camadas**
- **@Transactional nas operações de escrita**

---

# ⚠️ Tratamento Global de Exceções

Implementado com:

```java
@ControllerAdvice
public class GlobalExceptionHandler {
```

Exceções mapeadas até agora:

- `DepartamentoNaoEncontradoException`
- `CursoNaoEncontradoException`
- `DisciplinaNaoEncontradaException`

Retorno padronizado:
- timestamp
- status
- message

---

# 🚀 Endpoints Implementados

## Professores
- `POST /api/v1/professores/cadastrar`

## Departamentos
- `POST /api/v1/departamentos/cadastrar` *(já implementado antes)*

## Cursos
- `POST /api/v1/cursos/cadastrar`

## Disciplinas
- `POST /api/v1/disciplinas/cadastrar`

## Turmas
- `POST /api/v1/turmas/cadastrar`

---

# 📝 Próximos Passos
- Criar entidade Sala (1:1 com Professor)
- Criar GET com DTOs enriquecidos usando EntityGraph
- Criar módulo Biblioteca, Equipamentos e Projetos (conforme minimundo)
- Adicionar validações Bean Validation nos DTOs

---

# 📌 Objetivo do Projeto
Este repositório serve como:

- estudo prático de Spring Boot + JPA,
- desenvolvimento de um backend completo baseado em regras reais,
- consolidar aprendizado sobre modelagem relacional,
- demonstrar habilidades para portfólio.

---

# 👤 Autor
**Miller Santos**
Desenvolvedor Backend em formação — focado em Java, Spring Boot e modelagem limpa.
