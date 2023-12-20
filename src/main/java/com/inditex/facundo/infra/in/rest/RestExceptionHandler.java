package com.inditex.facundo.infra.in.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
  @ExceptionHandler(DateTimeParseException.class)
  ResponseEntity<Object> dateParseError(DateTimeParseException ex){
    log.debug("handling exception::" + ex);
    return ResponseEntity.badRequest().body(ex.getMessage());
  }
}
