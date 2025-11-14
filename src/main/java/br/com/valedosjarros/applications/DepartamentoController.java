package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.departamento.CadastrarDepartamentoRequestDto;
import br.com.valedosjarros.domain.dtos.response.departamento.CadastrarDepartamentoResponseDto;
import br.com.valedosjarros.domain.services.DepartamentoService;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarDepartamentoResponseDto> post(@RequestBody CadastrarDepartamentoRequestDto request){
		var response = departamentoService.cadastrarDepartamento(request);
		return ResponseEntity.ok(response);
	}

}
