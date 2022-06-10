package dev.baz.capstone.controller.advice;

import dev.baz.capstone.dto.ErrorDetails;
import dev.baz.capstone.exception.AlreadyRegisteredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(AlreadyRegisteredException.class)
  public ResponseEntity<ErrorDetails> exceptionAlreadyRegisteredHandler() {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("Student already registered for this session.");
    return ResponseEntity
        .badRequest()
        .body(errorDetails);
  }
}
