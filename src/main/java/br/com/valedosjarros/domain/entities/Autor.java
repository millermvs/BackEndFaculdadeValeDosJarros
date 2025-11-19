package br.com.valedosjarros.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "autores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idAutor;
	
	@Column(nullable = false, length = 80)
	private String nomeAutor;
	
	@Column(nullable = false, unique = true, length = 11)
	private String cpfAutor;

	@ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
	private Set<Livro> livros = new HashSet<Livro>();

}
