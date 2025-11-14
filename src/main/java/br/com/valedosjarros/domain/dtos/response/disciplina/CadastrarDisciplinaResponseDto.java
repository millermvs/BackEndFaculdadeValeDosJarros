package br.com.valedosjarros.domain.dtos.response.disciplina;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarDisciplinaResponseDto {

	private Long id;
	private String nomeDisciplina;
	private String nomeCurso;
	private String resposta;
}
