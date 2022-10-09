package com.bwe.readingoasis.exception.handler;

import com.bwe.readingoasis.exception.ResourceNotFoundException;
import com.bwe.readingoasis.model.ApiError;
import com.bwe.readingoasis.model.ApiErrorCode;
import java.time.Instant;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception Handler for custom ReadingOasis exceptions.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ReadingOasisExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  protected ResponseEntity<ApiError> handleEntityNotFound(ResourceNotFoundException ex) {
    ApiError apiError = ApiError.builder()
        .setCode(ApiErrorCode.NOT_FOUND)
        .setMessage(ex.getMessage())
        .setTime(Instant.now())
        .setStatus(HttpStatus.NOT_FOUND.value())
        .build();
    return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
  }
}
