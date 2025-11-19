package br.com.valedosjarros.domain.dtos.response.autor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarAutorResponseDto {

	private Long idAutor;
	private String nomeAutor;
	private String cpfAutor;
	private String resposta;
}
