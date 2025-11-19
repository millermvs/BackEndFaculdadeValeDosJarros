package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.autor.CadastrarAutorRequestDto;
import br.com.valedosjarros.domain.dtos.response.autor.CadastrarAutorResponseDto;
import br.com.valedosjarros.domain.entities.Autor;
import br.com.valedosjarros.domain.exceptions.CpfJaCadastradoException;
import br.com.valedosjarros.infrastructure.repositories.AutorRepository;
import jakarta.transaction.Transactional;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Transactional
	public CadastrarAutorResponseDto cadastrarAutor(CadastrarAutorRequestDto request) {

		var nomeAutorMinusculo = request.getNomeAutor().toLowerCase();
		var nomeAutorFormatado = nomeAutorMinusculo.substring(0, 1).toUpperCase() + nomeAutorMinusculo.substring(1);

		var autorFound = autorRepository.findByCpfAutor(request.getCpfAutor());
		if (autorFound.isPresent())
			throw new CpfJaCadastradoException();

		var novoAutor = new Autor();
		novoAutor.setNomeAutor(nomeAutorFormatado);
		novoAutor.setCpfAutor(request.getCpfAutor());
		autorRepository.save(novoAutor);

		var response = new CadastrarAutorResponseDto();
		response.setIdAutor(novoAutor.getIdAutor());
		response.setNomeAutor(novoAutor.getNomeAutor());
		response.setCpfAutor(novoAutor.getCpfAutor());
		response.setResposta("Autor foi cadastrado no sistema");
		return response;
	}
}
