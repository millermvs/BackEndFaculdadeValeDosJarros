package br.com.valedosjarros.domain.dtos.request.professor;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarProfessorRequestDto {
	
	private String nomeProfessor;
	private Long idDepartamento;
	
}
