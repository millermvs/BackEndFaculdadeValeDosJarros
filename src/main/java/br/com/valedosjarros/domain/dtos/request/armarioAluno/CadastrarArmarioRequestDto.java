package br.com.valedosjarros.domain.dtos.request.armarioAluno;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarArmarioRequestDto {

	@Pattern(regexp = "^[0-9]{1,5}$", message = "Somente números e até 5 caracteres.")
	private String nomeArmario;
}
