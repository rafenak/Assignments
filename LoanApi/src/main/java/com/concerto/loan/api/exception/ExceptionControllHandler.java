package com.concerto.loan.api.exception;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.concerto.loan.api.response.Messages;
import com.concerto.loan.api.response.Response;

@ControllerAdvice
public class ExceptionControllHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(Messages.FAILURE, ex.getMessage()));
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Response> handleEntityNotFoundException(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(Messages.FAILURE, ex.getMessage()));
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Response> entityExistHandler(EntityExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new Response(Messages.FAILURE, ex.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> ExceptionalHandler(Exception ex) {
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(Messages.FAILURE, ex.getMessage()));
	}
}
