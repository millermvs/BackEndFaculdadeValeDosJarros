package br.com.valedosjarros.domain.dtos.request.turma;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarTurmaRequestDto {

	private String nomeTurma;
	private Long idDisciplina;	
}
