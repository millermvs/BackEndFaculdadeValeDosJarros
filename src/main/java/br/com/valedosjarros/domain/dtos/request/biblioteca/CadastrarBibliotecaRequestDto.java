package br.com.valedosjarros.domain.dtos.request.biblioteca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarBibliotecaRequestDto {

	@NotBlank(message = "Campo não pode estar vazio.")
	@Pattern(regexp = "^[0-9A-Za-zÀ-Üà-ü]{1,30}$", message = "Nome inválido, somente letras e números.")
	private String nomeBiblioteca;
	
	@NotNull(message = "Campo não pode estar vazio.")
	private Long idDepartamento;
}
