package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.aluno.CadastrarAlunoRequestDto;
import br.com.valedosjarros.domain.dtos.response.aluno.CadastrarAlunoResponseDto;
import br.com.valedosjarros.domain.entities.Aluno;
import br.com.valedosjarros.domain.exceptions.ArmarioNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.ArmarioOcupadoException;
import br.com.valedosjarros.domain.exceptions.CpfJaCadastradoException;
import br.com.valedosjarros.infrastructure.repositories.AlunoRepository;
import br.com.valedosjarros.infrastructure.repositories.ArmarioRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ArmarioRepository armarioRepository;
	
	@Transactional
	public CadastrarAlunoResponseDto cadastrarAluno(CadastrarAlunoRequestDto request) {
		var alunoFound = alunoRepository.findByCpf(request.getCpf());
			if (alunoFound.isPresent())
				throw new CpfJaCadastradoException();
		
		var armarioFound = armarioRepository.findByIdArmario(request.getIdArmario())
				.orElseThrow(ArmarioNaoEncontradoException::new);
		
			if(armarioFound.getAluno() != null)
				throw new ArmarioOcupadoException();			
			
		var alunoNovo = new Aluno();
		alunoNovo.setNome(request.getNomeAluno());
		alunoNovo.setCpf(request.getCpf());
		alunoNovo.setArmarioAluno(armarioFound);
		alunoRepository.save(alunoNovo);
		armarioFound.setAluno(alunoNovo);
		armarioRepository.save(armarioFound);
		
		
		var response = new CadastrarAlunoResponseDto();
		response.setId(alunoNovo.getIdAluno());
		response.setNome(alunoNovo.getNome());
		response.setCpf(alunoNovo.getCpf());
		response.setArmarioAluno(alunoNovo.getArmarioAluno().getNomeArmario());
		response.setResposta("Aluno foi cadastrado no sistema.");
		
		return response;
	}

}
