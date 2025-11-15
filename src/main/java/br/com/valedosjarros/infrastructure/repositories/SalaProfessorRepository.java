package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.SalaProfessor;

@Repository
public interface SalaProfessorRepository extends JpaRepository<SalaProfessor, Integer>{
	
	@EntityGraph(attributePaths = "professor")
	Optional<SalaProfessor> findByNomeSala(String nomeSala);

}
