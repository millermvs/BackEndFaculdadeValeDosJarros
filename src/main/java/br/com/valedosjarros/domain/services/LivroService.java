package br.com.valedosjarros.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.livros.CadastrarLivroRequestDto;
import br.com.valedosjarros.domain.dtos.response.livros.CadastrarLivroResponseDto;
import br.com.valedosjarros.domain.entities.Autor;
import br.com.valedosjarros.domain.entities.Livro;
import br.com.valedosjarros.domain.exceptions.BibliotecaNaoEncontradaException;
import br.com.valedosjarros.infrastructure.repositories.AutorRepository;
import br.com.valedosjarros.infrastructure.repositories.BibliotecaRepository;
import br.com.valedosjarros.infrastructure.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private AutorService autorService;

	public CadastrarLivroResponseDto cadastrarLivro(CadastrarLivroRequestDto request) {

		var bibliotecaFound = bibliotecaRepository.findByIdBiblioteca(request.getIdBiblioteca())
				.orElseThrow(BibliotecaNaoEncontradaException::new);

		var nomeLivroMinusculo = request.getNomeLivro();
		var nomeLivroFormatado = nomeLivroMinusculo.substring(0, 1).toUpperCase() + nomeLivroMinusculo.substring(1);

		var novoLivro = new Livro();
		novoLivro.setNomeLivro(nomeLivroFormatado);
		novoLivro.setBiblioteca(bibliotecaFound);
		bibliotecaFound.getLivros().add(novoLivro);

		for (var i = 0; i <= request.getIdAutores().size(); i++) {
			var autorFound = autorRepository.findByIdAutor(request.getIdAutores().get(i)).get();
			novoLivro.getAutores().add(autorFound);
		}

		
		livroRepository.save(novoLivro);

		var response = new CadastrarLivroResponseDto();
		return response;
	}

}
