package br.com.valedosjarros.domain.exceptions;


public class NomeArmarioJaExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Este nome de armário já foi cadastrado.";
	}

}
