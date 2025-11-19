package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.autor.CadastrarAutorRequestDto;
import br.com.valedosjarros.domain.dtos.response.autor.CadastrarAutorResponseDto;
import br.com.valedosjarros.domain.services.AutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarAutorResponseDto> post(@Valid @RequestBody CadastrarAutorRequestDto request) {
		var response = autorService.cadastrarAutor(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
