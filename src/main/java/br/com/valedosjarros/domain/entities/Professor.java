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
@Table(name = "professores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Professor {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idProfessor;
	
	@Column
	private String nomeProfessor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento")
	private Departamento departamento;
	
	@OneToOne(mappedBy = "professor", fetch = FetchType.LAZY)
	private SalaProfessor salaProfessor;
	
	@OneToMany (mappedBy = "professor", fetch = FetchType.LAZY)
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

}
