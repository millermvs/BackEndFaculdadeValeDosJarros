package br.com.valedosjarros.domain.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Autor não encontrado.";
	}

}
