package br.com.valedosjarros.domain.exceptions;

public class DisciplinaNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Disciplina não encontrada.";
	}

}
