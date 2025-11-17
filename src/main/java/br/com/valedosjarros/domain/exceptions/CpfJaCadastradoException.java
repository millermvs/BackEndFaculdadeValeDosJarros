package br.com.valedosjarros.domain.exceptions;

public class CpfJaCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Cpf já cadastrado no sistema.";
	}

}
