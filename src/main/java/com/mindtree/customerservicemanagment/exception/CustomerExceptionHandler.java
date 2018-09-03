package com.mindtree.customerservicemanagment.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,
			WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(
			CustomerNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record Not Found", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}
