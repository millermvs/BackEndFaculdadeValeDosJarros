package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@EntityGraph(attributePaths = "matricula")
	Optional<Aluno> findByIdAluno(Long id);
}
