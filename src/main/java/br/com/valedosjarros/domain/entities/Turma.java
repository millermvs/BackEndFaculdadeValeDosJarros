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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "turmas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idTurma;	
	
	@Column
	private String nomeTurma;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_disciplina", referencedColumnName = "idDisciplina")
	private Disciplina disciplina;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
	private Set<Matricula> matriculas = new HashSet<Matricula>();
}
