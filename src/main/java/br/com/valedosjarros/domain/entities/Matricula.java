package br.com.valedosjarros.domain.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "matriculas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idMatricula;
	
	private Date dataInscrição;
	
	private Double notaFinal;
	
	@OneToOne(mappedBy = "matricula",fetch = FetchType.LAZY)
	private Aluno aluno;
	
	
//	private List<Disciplina> disciplinas;

}
