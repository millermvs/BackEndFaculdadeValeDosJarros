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
@Table(name = "armarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArmarioAluno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Integer idArmario;
	
	@Column
	private String nomeArmario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno", referencedColumnName = "idAluno")
	private Aluno aluno;
}
