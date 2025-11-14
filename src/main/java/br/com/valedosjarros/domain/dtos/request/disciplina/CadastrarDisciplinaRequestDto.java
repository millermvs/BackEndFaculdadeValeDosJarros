package br.com.valedosjarros.domain.dtos.request.disciplina;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarDisciplinaRequestDto {
	
	private String nomeDisciplina;
	private Long idCurso;

}
