package br.com.valedosjarros.domain.dtos.request.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
	
	@NotNull
	@Positive
	private Integer idArmario;

}
