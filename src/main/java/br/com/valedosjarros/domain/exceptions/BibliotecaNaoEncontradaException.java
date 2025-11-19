package br.com.valedosjarros.domain.exceptions;

public class BibliotecaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Biblioteca não encontrada.";
	}

}
