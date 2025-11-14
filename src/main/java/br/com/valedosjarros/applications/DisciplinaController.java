package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.disciplina.CadastrarDisciplinaRequestDto;
import br.com.valedosjarros.domain.dtos.response.disciplina.CadastrarDisciplinaResponseDto;
import br.com.valedosjarros.domain.services.DisciplinaService;

@RestController
@RequestMapping("/api/v1/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarDisciplinaResponseDto> post(@RequestBody CadastrarDisciplinaRequestDto request){
		var response = disciplinaService.cadastrarDisciplina(request);
		return ResponseEntity.ok(response);
	}

}
