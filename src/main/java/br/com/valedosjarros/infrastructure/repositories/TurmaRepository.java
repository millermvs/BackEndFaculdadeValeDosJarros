package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	@EntityGraph(attributePaths = "disciplina")
	Optional<Turma> findByIdTurma(Long id);

}
