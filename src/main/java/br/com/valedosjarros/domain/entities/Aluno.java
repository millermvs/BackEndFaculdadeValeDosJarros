package br.com.valedosjarros.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "alunos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idAluno;

	@Column
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String cpf;

	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	private Set<Matricula> matriculas = new HashSet<Matricula>();
	
	@OneToOne(mappedBy = "aluno", fetch = FetchType.LAZY)
	private ArmarioAluno armarioAluno;

}