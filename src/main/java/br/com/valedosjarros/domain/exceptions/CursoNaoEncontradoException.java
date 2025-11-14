package br.com.valedosjarros.domain.exceptions;

public class CursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Curso não encontrado.";
	}

}
