package com.softtek.labelling.demo.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.softtek.labelling.demo.dto.ErrorDto;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	    
		ErrorDto apiError = new ErrorDto();
	    apiError.setErros(Arrays.asList("Encontramos um erro!"));
	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
	    
		ErrorDto apiError = new ErrorDto();
	    apiError.setErros(Arrays.asList(ex.getMessage()));
	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> erros = new ArrayList<String>();
		ex.getAllErrors()
			.forEach(x -> erros.add(x.getDefaultMessage()));
		
		ErrorDto dto = new ErrorDto();
		dto.setErros(erros);
		
		return new ResponseEntity<Object>(dto, new HttpHeaders(), status);
	}
		
}
