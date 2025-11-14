package br.com.valedosjarros.domain.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.valedosjarros.domain.exceptions.CursoNaoEncontradoException;
import br.com.valedosjarros.domain.exceptions.DepartamentoNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<Object> criaResponse(HttpStatus status, Exception ex) {

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", status.value());
		body.put("message", ex.getMessage());

		return ResponseEntity.status(status.value()).body(body);
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
}
