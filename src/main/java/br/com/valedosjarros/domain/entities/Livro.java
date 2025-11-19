package br.com.valedosjarros.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "livros")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idLivro;

	@Column(length = 50)
	private String nomeLivro;

	@OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
	private Set<Emprestimo> emprestimos = new HashSet<Emprestimo>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_biblioteca", referencedColumnName = "idBiblioteca")
	private Biblioteca biblioteca;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livros_autores", joinColumns = @JoinColumn(name = "id_livro", referencedColumnName = "idLivro"), 
	inverseJoinColumns = @JoinColumn(name = "id_autor", referencedColumnName = "idAutor"), 
	uniqueConstraints = @UniqueConstraint(columnNames = {"id_livro", "id_autor" })
	)
	private Set<Autor> autores = new HashSet<Autor>();
}
