# Faculdade Vale dos Jarros — Modelo Acadêmico (Projeto de Estudo com Spring Boot + PostgreSQL)

Este projeto é parte do meu treino pessoal em **modelagem de dados**, **Spring Boot**, **Spring Data JPA**, **PostgreSQL** e **boas práticas de arquitetura**.  
A ideia é transformar um *minimundo* em um projeto completo com entidades, relacionamentos, serviços, consultas e integração com banco de dados.

---

## 🎯 Objetivo do Projeto

Modelar e implementar, em Java + Spring Boot, o sistema acadêmico da **Faculdade Vale dos Jarros**, incluindo:

- Departamentos  
- Cursos  
- Professores  
- Salas  
- Disciplinas  
- Alunos  
- Armários  
- Matrículas  
- Biblioteca (livros, autores, empréstimos)  
- Laboratório de redes (equipamentos, técnicos, turmas)  
- Projetos finais (grupos, orientadores)

O foco inicial é **criar o modelo conceitual e lógico**, e depois construir gradualmente todas as entidades e relacionamentos usando JPA.

---

## 🧩 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL 15+**
- **Hibernate**
- **Lombok**
- **Maven**

---

## 🗄️ Configuração do Banco de Dados

O projeto usa PostgreSQL local.  


### 📝 Observações
- É necessário ter um banco chamado **db_faculdade_vale_dos_jarros** criado.
- O usuário **postgres** deve ter acesso total ao banco.
- `ddl-auto=update` é usado **apenas para ambiente local de estudo**.

---

## 🏗️ Estrutura do Projeto (em evolução)

```
br.com.valedosjarros
 └── domain
      ├── entities         ← todas as entidades JPA
      ├── dtos             ← DTOs (futuro)
      ├── services         ← lógica de negócio
      └── repositories     ← interfaces do Spring Data
```

---

## 📌 Relacionamentos já implementados

### ✔ Departamento (1) → Cursos (N)

- Departamento = lado **pai**
- Curso = lado **filho** (contém FK `id_departamento`)
- `mappedBy` utilizado corretamente no pai
- `fetch = LAZY` em todas as associações

---

## 🎓 Minimundo (Resumo)

Este projeto se baseia no seguinte cenário:

- Cada **Aluno** possui **um único Armário**.
- Cada **Professor** ocupa **uma Sala exclusiva**.
- Cada **Disciplina** pertence a **um Curso** e é ministrada por **um único Professor**.
- **Alunos** podem se matricular em muitas disciplinas, com histórico de notas.
- A **Biblioteca** registra empréstimos de **Exemplares** (livros) para alunos.
- No laboratório, equipamentos críticos têm **técnico exclusivo**, enquanto outros são compartilhados por turmas.
- Projetos finais envolvem **Grupos**, **Orientadores** e **Alunos participantes**.

---

## 🚀 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU-USUARIO/SEU-REPO.git
   ```
2. Configure o PostgreSQL conforme o application.properties.
3. Rode:
   ```bash
   mvn spring-boot:run
   ```

---

## 📅 Status Atual do Projeto

- [x] Criação da estrutura base  
- [x] Configuração do banco  
- [x] Entidades iniciais (Departamento e Curso)  
- [ ] Relacionamentos com Professor  
- [ ] Modelagem da Biblioteca  
- [ ] Modelagem do Laboratório  
- [ ] Modelagem dos Projetos Finais  
- [ ] Serviços e Regras de Negócio  
- [ ] Controllers e Endpoints  
- [ ] Documentação da API (Swagger)

---

## 🤝 Contribuição

Projeto pessoal, mas aberto para melhorias, dúvidas e sugestões.

---

## 📧 Contato

Caso queira trocar ideias sobre arquitetura, JPA, modelagem ou Spring:  
**Miller Santos**