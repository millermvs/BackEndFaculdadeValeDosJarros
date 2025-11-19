package br.com.valedosjarros.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@EntityGraph(attributePaths = "emprestimos")
	Optional<Livro> findByIdLivro(Long idLivro);
	
	
}
