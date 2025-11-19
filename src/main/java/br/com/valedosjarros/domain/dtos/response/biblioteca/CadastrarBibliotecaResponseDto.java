package br.com.valedosjarros.domain.dtos.response.biblioteca;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarBibliotecaResponseDto {

	private Long idBiblioteca;
	private String nomeBiblioteca;
	private String departamento;
	private String resposta;
}
