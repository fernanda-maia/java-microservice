package io.github.fernanda.maia.product.exception;

import io.github.fernanda.maia.product.exception.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException e) {
        ExceptionResponse response = ExceptionResponse.builder()
                .message(e.getMessage())
                .error("BAD REQUEST")
                .code(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ExceptionResponse> handleNotFound(NotFoundException e) {
        ExceptionResponse response = ExceptionResponse.builder()
                .error("NOT FOUND")
                .message(e.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
