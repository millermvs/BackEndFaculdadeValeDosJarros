package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.curso.CadastrarCursoRequestDto;
import br.com.valedosjarros.domain.dtos.response.curso.CadastrarCursoResponseDto;
import br.com.valedosjarros.domain.entities.Curso;
import br.com.valedosjarros.infrastructure.repositories.DepartamentoRepository;

@Service
public class CursoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public CadastrarCursoResponseDto cadastrarCurso(CadastrarCursoRequestDto request) {
		
		var departamentoFound = departamentoRepository.findById(request.getIdDepartamento());
//		TODO

		var nomeCursoMinusculo = request.getNomeCurso().toLowerCase();
		var nomeCursoFormatado = nomeCursoMinusculo.substring(0, 1).toUpperCase() + nomeCursoMinusculo.substring(1);

		var curso = new Curso();
		curso.setNomeCurso(nomeCursoFormatado);
//		curso.setDepartamento(request.getDepartamento());

		var response = new CadastrarCursoResponseDto();
		response.setIdCurso(curso.getIdCurso());
		response.setNomeCurso(curso.getNomeCurso());
//		response.setDepartamento(request.getDepartamento());
		response.setResposta("Curso de " + curso.getNomeCurso() + " foi cadastrado.");

		return response;
	}
}
