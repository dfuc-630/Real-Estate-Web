package com.controller_advice;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Model.ErrorResponseDTO;

import customExceptions.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
    @ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArgument(
	            ArithmeticException ex, WebRequest request) {

	       ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO() ; 
	       errorResponseDTO.setError(ex.getMessage());
	       List<String> details = new ArrayList<>() ; 
	       details.add("so nguyen lam sao chia duoc cho 0") ; 
	       details.add("so nguyen lam sao chia duoc cho 0") ; 
	       details.add("so nguyen lam sao chia duoc cho 0") ; 

	       errorResponseDTO.setDetail(details);
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
	    }
}
