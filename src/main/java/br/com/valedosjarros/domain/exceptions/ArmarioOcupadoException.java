package br.com.valedosjarros.domain.exceptions;

public class ArmarioOcupadoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Armário ocupado.";
	}

}
