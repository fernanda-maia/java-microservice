package io.github.fernanda.maia.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException e) {
        ExceptionResponse response = ExceptionResponse.builder() .error("Bad Request")
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CouponNotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleNotFound(CouponNotFoundException e) {
        ExceptionResponse response = ExceptionResponse.builder().error("Not Found")
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
