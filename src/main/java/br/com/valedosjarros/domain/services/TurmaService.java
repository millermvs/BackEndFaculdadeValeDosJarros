package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.turma.CadastrarTurmaRequestDto;
import br.com.valedosjarros.domain.dtos.response.turma.CadastrarTurmaResponseDto;
import br.com.valedosjarros.domain.entities.Turma;
import br.com.valedosjarros.domain.exceptions.DisciplinaNaoEncontradaException;
import br.com.valedosjarros.infrastructure.repositories.DisciplinaRepository;
import br.com.valedosjarros.infrastructure.repositories.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Transactional
	public CadastrarTurmaResponseDto cadastrarTurma(CadastrarTurmaRequestDto request) {

		var disciplinaFound = disciplinaRepository.findByIdDisciplina(request.getIdDisciplina())
				.orElseThrow(DisciplinaNaoEncontradaException::new);

		var novaTurma = new Turma();
		novaTurma.setNomeTurma(request.getNomeTurma());
		novaTurma.setDisciplina(disciplinaFound);
		disciplinaFound.getTurmas().add(novaTurma);
		turmaRepository.save(novaTurma);

		var response = new CadastrarTurmaResponseDto();
		response.setIdTurma(novaTurma.getIdTurma());
		response.setNomeTurma(novaTurma.getNomeTurma());
		response.setDisciplina(novaTurma.getDisciplina().getNomeDisciplina());
		response.setResposta("Nova turma foi cadastrada para a disciplina.");

		return response;

	}
}
