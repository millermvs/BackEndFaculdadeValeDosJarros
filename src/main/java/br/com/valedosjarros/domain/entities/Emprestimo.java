package br.com.valedosjarros.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "emprestimos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idEmprestimo;

	@Column(nullable = false)
	private LocalDate dataEmprestimo;

	@Column(nullable = false)
	private LocalDate dataPrevistaDevolucao;

	@Column
	private LocalDate dataDevolucao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_livro", referencedColumnName = "idLivro")
	private Livro livro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno", referencedColumnName = "idAluno")
	private Aluno aluno;

}
