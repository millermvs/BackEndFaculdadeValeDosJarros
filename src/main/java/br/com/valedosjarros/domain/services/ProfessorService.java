package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.professor.CadastrarProfessorRequestDto;
import br.com.valedosjarros.domain.dtos.response.professor.CadastrarProfessorResponseDto;
import br.com.valedosjarros.domain.entities.Professor;
import br.com.valedosjarros.domain.exceptions.DepartamentoNaoEncontradoException;
import br.com.valedosjarros.infrastructure.repositories.DepartamentoRepository;
import br.com.valedosjarros.infrastructure.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;

@Service
public class ProfessorService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Transactional
	public CadastrarProfessorResponseDto cadastrarProfessor(CadastrarProfessorRequestDto request) {

		var departamentoFound = departamentoRepository.findByIdDepartamento(request.getIdDepartamento())
				.orElseThrow(DepartamentoNaoEncontradoException::new);

		var nomeProfessorMinusculo = request.getNomeProfessor().toLowerCase();
		var nomeProfessorFormatado = nomeProfessorMinusculo.substring(0, 1).toUpperCase()
				+ nomeProfessorMinusculo.substring(1);

		var novoProfessor = new Professor();
		novoProfessor.setNomeProfessor(nomeProfessorFormatado);
		novoProfessor.setDepartamento(departamentoFound);
		departamentoFound.getProfessores().add(novoProfessor);
		professorRepository.save(novoProfessor);

		var response = new CadastrarProfessorResponseDto();
		response.setIdProfessor(novoProfessor.getIdProfessor());
		response.setNomeProfessor(novoProfessor.getNomeProfessor());
		response.setDepartamento(novoProfessor.getDepartamento().getNomeDepartamento());
		response.setResposta("Professor " + novoProfessor.getNomeProfessor() + " cadastrado no departamento.");

		return response;
	}

}
