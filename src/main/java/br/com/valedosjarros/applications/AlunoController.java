package br.com.valedosjarros.applications;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

	@PostMapping("cadastrar")
	public ResponseEntity<?> post(){
		return null;
	}
}
