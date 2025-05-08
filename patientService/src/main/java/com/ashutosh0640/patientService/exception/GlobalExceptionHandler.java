package com.ashutosh0640.patientService.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashutosh0640.patientService.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorResponseDTO errorRes = new ErrorResponseDTO(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				"Resource not found",
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errorRes, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@ExceptionHandler(DuplicateResourceFoundExcepiton.class)
	public ResponseEntity<ErrorResponseDTO> handleDuplicateResourceFoundException(DuplicateResourceFoundExcepiton ex) {

		ErrorResponseDTO errorRes = new ErrorResponseDTO(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				"Resource not found",
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errorRes, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		Map<String, String> message = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error->message.put(error.getField(), error.getDefaultMessage()));
		
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}
