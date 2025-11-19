package br.com.valedosjarros.domain.dtos.request.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarAutorRequestDto {

	@NotBlank
	@Size(min = 1, max = 80, message = "O nome deve conter entre 1 e 80 caracteres.")
	private String nomeAutor;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{11}$", message = "Campo deve conter 11 números.")
	private String cpfAutor;
	
}
