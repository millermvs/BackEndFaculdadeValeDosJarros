package br.com.valedosjarros.domain.dtos.response.turma;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarTurmaResponseDto {

	private Long idTurma;
	private String nomeTurma;
	private String disciplina;
	private String resposta;
}
