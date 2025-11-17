package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.ArmarioAluno;

@Repository
public interface ArmarioRepository extends JpaRepository<ArmarioAluno, Integer>{

	@EntityGraph(attributePaths = "aluno")
	Optional<ArmarioAluno> findByIdArmario(Integer idArmario);
	
	@EntityGraph(attributePaths = "aluno")
	Optional<ArmarioAluno> findByNomeArmario(String nomeArmario);
	
	
}
