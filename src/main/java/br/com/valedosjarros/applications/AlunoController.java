package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.aluno.CadastrarAlunoRequestDto;
import br.com.valedosjarros.domain.dtos.response.aluno.CadastrarAlunoResponseDto;
import br.com.valedosjarros.domain.services.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarAlunoResponseDto> post(@Valid @RequestBody CadastrarAlunoRequestDto request){
		var response = alunoService.cadastrarAluno(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
