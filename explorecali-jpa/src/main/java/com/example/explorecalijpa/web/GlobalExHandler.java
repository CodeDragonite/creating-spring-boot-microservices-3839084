package com.example.explorecalijpa.web;

import java.util.NoSuchElementException;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExHandler extends ResponseEntityExceptionHandler {

  /**
   * Leverage Exception Handler framework for resource not found Exception.
   * 
   * @param ex      ResourceNotFoundException
   * @param request WebRequest
   * @return http response
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<Object> handleResourceNotFoundException(
      ResourceNotFoundException ex, WebRequest request) {
    logException(ex);
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    return createResponseEntity(pd, null, HttpStatus.NOT_FOUND, request);
  }

  /**
   * Leverage Exception Handler framework for id not found Exception.
   * 
   * @param ex      NoSuchElementException
   * @param request WebRequest
   * @return http response
   */
  @ExceptionHandler(NoSuchElementException.class)
  public final ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {

    logException(ex);
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    return createResponseEntity(pd, null, HttpStatus.NOT_FOUND, request);
  }

  /**
   * Leverage Exception Handler frameworf for unexpected Exceptions.
   * 
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleNoSuchElementException(Exception ex, WebRequest request) {
    logException(ex);
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return createResponseEntity(pd, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  private void logException(Exception ex) {
    log.error("Caught Exception", ex);
  }

}