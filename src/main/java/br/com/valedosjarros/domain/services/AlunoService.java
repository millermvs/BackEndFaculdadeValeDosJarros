package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.aluno.CadastrarAlunoRequestDto;
import br.com.valedosjarros.domain.dtos.response.aluno.CadastrarAlunoResponseDto;
import br.com.valedosjarros.domain.exceptions.CpfJaCadastradoException;
import br.com.valedosjarros.infrastructure.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public CadastrarAlunoResponseDto cadastrarAluno(CadastrarAlunoRequestDto request) {
		var alunoFound = alunoRepository.findByCpf(request.getCpf());
			if (alunoFound.isPresent())
				throw new CpfJaCadastradoException();
//		TODO
		
		return null;
	}

}
