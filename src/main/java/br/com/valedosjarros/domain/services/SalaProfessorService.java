package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.salaProfessor.CadastrarSalaProfessorRequestDto;
import br.com.valedosjarros.domain.dtos.response.salaProfessor.CadastrarSalaProfessorResponseDto;
import br.com.valedosjarros.domain.entities.SalaProfessor;
import br.com.valedosjarros.domain.exceptions.NomeDaSalaJaExisteException;
import br.com.valedosjarros.infrastructure.repositories.SalaProfessorRepository;
import jakarta.transaction.Transactional;

@Service
public class SalaProfessorService {

	@Autowired
	private SalaProfessorRepository salaProfessorRepository;

	@Transactional
	public CadastrarSalaProfessorResponseDto cadastrarSalaProfessor(CadastrarSalaProfessorRequestDto request) {

		var salaProfessorFound = salaProfessorRepository.findByNomeSala(request.getNomeSala());
		if (salaProfessorFound.isPresent())
			throw new NomeDaSalaJaExisteException();

		var salaProfessorNova = new SalaProfessor();
		salaProfessorNova.setNomeSala(request.getNomeSala());
		salaProfessorRepository.save(salaProfessorNova);

		var response = new CadastrarSalaProfessorResponseDto();
		response.setIdSala(salaProfessorNova.getIdSala());
		response.setNomeSala(salaProfessorNova.getNomeSala());
		response.setResposta("Nova sala cadastrada.");
		return response;
	}

}
