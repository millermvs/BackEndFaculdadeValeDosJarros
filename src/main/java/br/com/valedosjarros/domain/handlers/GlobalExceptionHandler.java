package br.com.valedosjarros.domain.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.valedosjarros.domain.exceptions.ArmarioNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.ArmarioOcupadoException;
import br.com.valedosjarros.domain.exceptions.AutorNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.BibliotecaNaoEncontradaException;
import br.com.valedosjarros.domain.exceptions.BibliotecaNomeJaCadastradoException;
import br.com.valedosjarros.domain.exceptions.CpfJaCadastradoException;
import br.com.valedosjarros.domain.exceptions.CursoNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.DepartamentoNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.DisciplinaNaoEncontradaException;
import br.com.valedosjarros.domain.exceptions.NomeArmarioJaExisteException;
import br.com.valedosjarros.domain.exceptions.NomeDaSalaJaExisteException;

@ControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<Object> criaResponse(HttpStatus status, Exception ex) {

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", status.value());
		body.put("message", ex.getMessage());

		return ResponseEntity.status(status.value()).body(body);
	}

	@ExceptionHandler(NomeDaSalaJaExisteException.class)
	public ResponseEntity<Object> handlerNomeDaSalaJaExiste(NomeDaSalaJaExisteException ex) {
		var response = criaResponse(HttpStatus.CONFLICT, ex);
		return response;
	}

	@ExceptionHandler(CursoNaoEncontradoException.class)
	public ResponseEntity<Object> handlerCursoNaoEncontrado(CursoNaoEncontradoException ex) {
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}

	@ExceptionHandler(DepartamentoNaoEncontradoException.class)
	public ResponseEntity<Object> handlerDepartamentoNaoEncontrado(DepartamentoNaoEncontradoException ex) {
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}

	@ExceptionHandler(DisciplinaNaoEncontradaException.class)
	public ResponseEntity<Object> handlerDisciplinaNaoEncontrada(DisciplinaNaoEncontradaException ex) {
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}

	@ExceptionHandler(NomeArmarioJaExisteException.class)
	public ResponseEntity<Object> handlerNomeArmarioJaExiste(NomeArmarioJaExisteException ex) {
		var response = criaResponse(HttpStatus.CONFLICT, ex);
		return response;
	}

	@ExceptionHandler(CpfJaCadastradoException.class)
	public ResponseEntity<Object> handlerCpfJaCadastrado(CpfJaCadastradoException ex) {
		var response = criaResponse(HttpStatus.CONFLICT, ex);
		return response;
	}

	@ExceptionHandler(ArmarioOcupadoException.class)
	public ResponseEntity<Object> handlerArmarioOcupado(ArmarioOcupadoException ex) {
		var response = criaResponse(HttpStatus.CONFLICT, ex);
		return response;
	}

	@ExceptionHandler(ArmarioNaoEncontradoException.class)
	public ResponseEntity<Object> handlerArmarioNaoEncontrado(ArmarioNaoEncontradoException ex) {
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}

	@ExceptionHandler(BibliotecaNomeJaCadastradoException.class)
	public ResponseEntity<Object> handlerBibliotecaNomeJaCadastrado(BibliotecaNomeJaCadastradoException ex) {
		var response = criaResponse(HttpStatus.CONFLICT, ex);
		return response;
	}

	@ExceptionHandler(BibliotecaNaoEncontradaException.class)
	public ResponseEntity<Object> handlerBibliotecaNaoEncontrada(BibliotecaNaoEncontradaException ex) {
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<Object> handlerAutorNaoEncontrado(AutorNaoEncontradoException ex){
		var response = criaResponse(HttpStatus.NOT_FOUND, ex);
		return response;
	}
}
