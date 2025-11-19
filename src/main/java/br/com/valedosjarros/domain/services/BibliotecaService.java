package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.biblioteca.CadastrarBibliotecaRequestDto;
import br.com.valedosjarros.domain.dtos.response.biblioteca.CadastrarBibliotecaResponseDto;
import br.com.valedosjarros.domain.entities.Biblioteca;
import br.com.valedosjarros.domain.exceptions.BibliotecaNomeJaCadastradoException;
import br.com.valedosjarros.domain.exceptions.DepartamentoNaoEncontradoException;
import br.com.valedosjarros.infrastructure.repositories.BibliotecaRepository;
import br.com.valedosjarros.infrastructure.repositories.DepartamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class BibliotecaService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private BibliotecaRepository bibliotecaRepository;

	@Transactional
	public CadastrarBibliotecaResponseDto cadastrarBiblioteca(CadastrarBibliotecaRequestDto request) {
		var departamentoFound = departamentoRepository.findByIdDepartamento(request.getIdDepartamento())
				.orElseThrow(DepartamentoNaoEncontradoException::new);

		var nomeBibliotecaMinusculo = request.getNomeBiblioteca().toLowerCase();
		var nomeBibliotecaFormatado = nomeBibliotecaMinusculo.substring(0, 1).toUpperCase()
				+ nomeBibliotecaMinusculo.substring(1);

		var bibliotecaFound = bibliotecaRepository.findByNomeBiblioteca(nomeBibliotecaFormatado);
		if (bibliotecaFound.isPresent())
			throw new BibliotecaNomeJaCadastradoException();

		var bibliotecaNova = new Biblioteca();
		bibliotecaNova.setNomeBiblioteca(nomeBibliotecaFormatado);
		bibliotecaNova.setDepartamento(departamentoFound);
		departamentoFound.setBiblioteca(bibliotecaNova);
		bibliotecaRepository.save(bibliotecaNova);

		var response = new CadastrarBibliotecaResponseDto();
		response.setIdBiblioteca(bibliotecaNova.getIdBiblioteca());
		response.setNomeBiblioteca(bibliotecaNova.getNomeBiblioteca());
		response.setDepartamento(bibliotecaNova.getDepartamento().getNomeDepartamento());
		response.setResposta("Nova biblioteca cadastrada.");
		return response;
	}
}
