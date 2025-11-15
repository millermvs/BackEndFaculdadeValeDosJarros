package br.com.valedosjarros.domain.dtos.request.salaProfessor;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarSalaProfessorRequestDto {
	
	@Pattern(regexp = "^[0-9]{1,10}$", message = "Apenas números, máx 10 caracteres.")
	private String nomeSala;

}
