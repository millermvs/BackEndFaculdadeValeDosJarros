package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.biblioteca.CadastrarBibliotecaRequestDto;
import br.com.valedosjarros.domain.dtos.response.biblioteca.CadastrarBibliotecaResponseDto;
import br.com.valedosjarros.domain.services.BibliotecaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/bibliotecas")
public class BibliotecaController {
	
	@Autowired
	private BibliotecaService bibliotecaService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarBibliotecaResponseDto> post(@Valid @RequestBody CadastrarBibliotecaRequestDto request){
		var response = bibliotecaService.cadastrarBiblioteca(request); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
