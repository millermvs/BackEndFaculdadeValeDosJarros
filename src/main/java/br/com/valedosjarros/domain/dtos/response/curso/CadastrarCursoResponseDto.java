package br.com.valedosjarros.domain.dtos.response.curso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarCursoResponseDto {

	private Long idCurso;
	private String nomeCurso;
	private String departamento;
	private String resposta;
	
}
