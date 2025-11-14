package br.com.valedosjarros.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valedosjarros.domain.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
