package br.com.valedosjarros.domain.dtos.response.professor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarProfessorResponseDto {
	
	private Long idProfessor;
	private String nomeProfessor;
	private String departamento;
	private String resposta;

}
