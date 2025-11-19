package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

	@EntityGraph(attributePaths = "departamento")
	Optional<Biblioteca> findByIdBiblioteca(Long idBiblioteca);
	
	@EntityGraph(attributePaths = "departamento")
	Optional<Biblioteca> findByNomeBiblioteca(String nomeBiblioteca);
}
