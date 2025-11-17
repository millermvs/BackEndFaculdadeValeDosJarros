package br.com.valedosjarros.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valedosjarros.domain.dtos.request.armarioAluno.CadastrarArmarioRequestDto;
import br.com.valedosjarros.domain.dtos.response.armarioAluno.CadastrarArmarioResponseDto;
import br.com.valedosjarros.domain.services.ArmarioAlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/armarios")
public class ArmarioAlunoController {
	
	@Autowired
	private ArmarioAlunoService armarioAlunoService;

	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarArmarioResponseDto> post(@Valid @RequestBody CadastrarArmarioRequestDto request) {
		var response = armarioAlunoService.cadastrarArmario(request);
		return ResponseEntity.ok(response);
	}

}
