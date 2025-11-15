package br.com.valedosjarros.domain.exceptions;

public class NomeDaSalaJaExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Já existe uma sala com esse nome.";
	}

}
