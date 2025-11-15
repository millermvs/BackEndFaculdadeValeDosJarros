package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.professor.CadastrarProfessorRequestDto;
import br.com.valedosjarros.domain.dtos.response.professor.CadastrarProfessorResponseDto;
import br.com.valedosjarros.domain.services.ProfessorService;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarProfessorResponseDto> post(@RequestBody CadastrarProfessorRequestDto request){
		var response = professorService.cadastrarProfessor(request);
		return ResponseEntity.ok(response);
	}
}
