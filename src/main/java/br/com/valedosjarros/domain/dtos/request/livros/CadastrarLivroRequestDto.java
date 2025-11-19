package br.com.valedosjarros.domain.dtos.request.livros;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarLivroRequestDto {

	@NotBlank
	@Size(min = 1, max = 50, message = "O nome do livro deve ter entre 1 e 50 caracteres.")
	private String nomeLivro;

	@NotNull(message = "A lista não pode estar vazia.")
	@Size(min = 1, message = "O livro deve ter pelo menos 1 autor.")
	private List<@NotNull(message = "O nome do autor é obrigatório") Long> idAutores;

	@NotNull
	private Long idBiblioteca;

}
