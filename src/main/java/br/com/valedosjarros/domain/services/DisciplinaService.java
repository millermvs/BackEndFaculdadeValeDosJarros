package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.disciplina.CadastrarDisciplinaRequestDto;
import br.com.valedosjarros.domain.dtos.response.disciplina.CadastrarDisciplinaResponseDto;
import br.com.valedosjarros.domain.entities.Disciplina;
import br.com.valedosjarros.domain.exceptions.CursoNaoEncontradoException;
import br.com.valedosjarros.infrastructure.repositories.CursoRepository;
import br.com.valedosjarros.infrastructure.repositories.DisciplinaRepository;
import jakarta.transaction.Transactional;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaResRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Transactional
	public CadastrarDisciplinaResponseDto cadastrarDisciplina(CadastrarDisciplinaRequestDto request) {

		var cursoFound = cursoRepository.findByIdCurso(request.getIdCurso())
				.orElseThrow(CursoNaoEncontradoException::new);

		var disciplinaNova = new Disciplina();
		disciplinaNova.setNomeDisciplina(request.getNomeDisciplina());
		disciplinaNova.setCurso(cursoFound);
		cursoFound.getDisciplinas().add(disciplinaNova);
		disciplinaResRepository.save(disciplinaNova);

		var response = new CadastrarDisciplinaResponseDto();
		response.setId(disciplinaNova.getIdDisciplina());
		response.setNomeDisciplina(disciplinaNova.getNomeDisciplina());
		response.setNomeCurso(disciplinaNova.getCurso().getNomeCurso());
		response.setResposta("Disciplina " + disciplinaNova.getNomeDisciplina() + " para o curso de "
				+ response.getNomeCurso() + " foi cadastrada.");

		return response;
	}
}
