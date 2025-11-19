package br.com.valedosjarros.domain.dtos.response.livros;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarLivroResponseDto {
	
	private Long idLivro;
	private String nomeLivro;
	private String nomeBiblioteca;
	private String resposta;	

}
