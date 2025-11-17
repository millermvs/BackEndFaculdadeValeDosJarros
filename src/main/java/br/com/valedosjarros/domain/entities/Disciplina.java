package br.com.valedosjarros.domain.entities;

import java.util.ArrayList;
import java.util.List;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "disciplinas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idDisciplina;

	@Column
	private String nomeDisciplina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", referencedColumnName = "idCurso")
	private Curso curso;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
	private List<Turma> turmas = new ArrayList<Turma>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_professor", referencedColumnName = "idProfessor")
	private Professor professor;

}
