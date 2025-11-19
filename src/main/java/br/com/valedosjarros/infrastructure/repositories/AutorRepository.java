package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	@EntityGraph(attributePaths = "livros")
	Optional<Autor> findByIdAutor(Long idAutor);
	
	@EntityGraph(attributePaths = "livros")
	Optional<Autor> findByCpfAutor(String cpfAutor);
}
