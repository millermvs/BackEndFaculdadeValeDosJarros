package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	@EntityGraph(attributePaths = "departamento")
	Optional<Professor> findByIdProfessor(Long id);
}
