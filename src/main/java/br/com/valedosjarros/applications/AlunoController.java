package br.com.valedosjarros.applications;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.aluno.CadastrarAlunoRequestDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

	@PostMapping("cadastrar")
	public ResponseEntity<?> post(@Valid @RequestBody CadastrarAlunoRequestDto request){
		var response = "TODO";
		return null;
	}
}
