package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.curso.CadastrarCursoRequestDto;
import br.com.valedosjarros.domain.services.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<?> post(@RequestBody CadastrarCursoRequestDto request){
		var response = cursoService.cadastrarCurso(request);
		return ResponseEntity.ok(response);
	}
}
