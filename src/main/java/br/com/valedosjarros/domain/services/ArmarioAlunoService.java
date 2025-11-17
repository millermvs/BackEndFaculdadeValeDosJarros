package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.armarioAluno.CadastrarArmarioRequestDto;
import br.com.valedosjarros.domain.dtos.response.armarioAluno.CadastrarArmarioResponseDto;
import br.com.valedosjarros.domain.entities.ArmarioAluno;
import br.com.valedosjarros.domain.exceptions.NomeArmarioJaExisteException;
import br.com.valedosjarros.infrastructure.repositories.ArmarioRepository;
import jakarta.transaction.Transactional;

@Service
public class ArmarioAlunoService {
	
	@Autowired
	private ArmarioRepository armarioRepository;

	@Transactional
	public CadastrarArmarioResponseDto cadastrarArmario(CadastrarArmarioRequestDto request) {
		
		var armarioFound = armarioRepository.findByNomeArmario(request.getNomeArmario());
		
		if(armarioFound.isPresent())
			throw new NomeArmarioJaExisteException();
		
		var novoArmarioAluno = new ArmarioAluno();
		novoArmarioAluno.setNomeArmario(request.getNomeArmario());
		armarioRepository.save(novoArmarioAluno);
		
		var response = new CadastrarArmarioResponseDto();
		response.setIdArmario(novoArmarioAluno.getIdArmario());
		response.setNomeArmario(novoArmarioAluno.getNomeArmario());
		response.setResposta("Armário cadastrado.");
		return response;
		
	}
}
