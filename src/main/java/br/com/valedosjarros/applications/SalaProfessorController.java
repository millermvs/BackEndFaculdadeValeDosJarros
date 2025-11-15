package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.salaProfessor.CadastrarSalaProfessorRequestDto;
import br.com.valedosjarros.domain.dtos.response.salaProfessor.CadastrarSalaProfessorResponseDto;
import br.com.valedosjarros.domain.services.SalaProfessorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaProfessorController {
	
	@Autowired
	private SalaProfessorService salaProfessorService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarSalaProfessorResponseDto> post(@Valid @RequestBody CadastrarSalaProfessorRequestDto request) {
		var response = salaProfessorService.cadastrarSalaProfessor(request);
		return ResponseEntity.ok(response);
	}

}
