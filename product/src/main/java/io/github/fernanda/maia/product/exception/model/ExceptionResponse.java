package io.github.fernanda.maia.product.exception.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String error;
    private String message;
    private int code;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
