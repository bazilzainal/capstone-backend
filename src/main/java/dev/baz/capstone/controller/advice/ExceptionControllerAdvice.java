package dev.baz.capstone.controller.advice;

import dev.baz.capstone.dto.ErrorDetails;
import dev.baz.capstone.exception.AlreadyRegisteredException;
import dev.baz.capstone.exception.NoSessionForDateException;
import dev.baz.capstone.exception.NoSessionForIdException;
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

  @ExceptionHandler(NoSessionForDateException.class)
  public ResponseEntity<ErrorDetails> exceptionNoSessionForDateHandler() {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("No sessions found for this date.");
    return ResponseEntity
        .badRequest()
        .body(errorDetails);
  }

  @ExceptionHandler(NoSessionForIdException.class)
  public ResponseEntity<ErrorDetails> exceptionNoSessionForIdHandler() {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("No sessions found for this ID.");
    return ResponseEntity
        .badRequest()
        .body(errorDetails);
  }
}