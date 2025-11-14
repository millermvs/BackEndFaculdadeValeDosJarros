package br.com.valedosjarros.domain.exceptions;

public class DepartamentoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Departamento não encontrado";
	}

}
