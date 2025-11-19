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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bibliotecas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long idBiblioteca;

	@Column(length = 30, nullable = false, unique = true)
	private String nomeBiblioteca;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento", unique = true)
	private Departamento departamento;
}
