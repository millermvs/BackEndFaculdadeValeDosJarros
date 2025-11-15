package br.com.valedosjarros.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "sala_professor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SalaProfessor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Integer idSala;

	@Column
	private String nomeSala;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_professor", referencedColumnName = "idProfessor")
	private Professor professor;
}
