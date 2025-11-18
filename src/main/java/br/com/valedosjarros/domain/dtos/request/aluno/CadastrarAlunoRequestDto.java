package br.com.valedosjarros.domain.dtos.request.aluno;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarAlunoRequestDto {

	@NotBlank
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{2,80}$", message = "Campo inválido.")
	private String nomeAluno;

	@NotBlank
	@Pattern(regexp = "^[0-9]{11}$", message = "Campo inválido.")
	private String cpf;

	
	@Max(10000)
	@Min(1)
	@NotNull(message = "Campo não pode ser nulo.")
	private Integer idArmario;

}
