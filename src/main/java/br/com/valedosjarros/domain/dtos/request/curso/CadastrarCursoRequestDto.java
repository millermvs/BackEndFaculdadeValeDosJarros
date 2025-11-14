package br.com.valedosjarros.domain.dtos.request.curso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarCursoRequestDto {
	
	private String nomeCurso;
	private Long idDepartamento;

}
