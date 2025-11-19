package br.com.valedosjarros.domain.exceptions;

public class BibliotecaNomeJaCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Nome da biblioteca já existe";
	}

}
