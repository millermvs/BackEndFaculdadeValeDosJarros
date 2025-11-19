package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.livros.CadastrarLivroRequestDto;
import br.com.valedosjarros.domain.dtos.response.livros.CadastrarLivroResponseDto;
import br.com.valedosjarros.domain.services.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarLivroResponseDto> post(@Valid @RequestBody CadastrarLivroRequestDto request) {
		var response = livroService.cadastrarLivro(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
