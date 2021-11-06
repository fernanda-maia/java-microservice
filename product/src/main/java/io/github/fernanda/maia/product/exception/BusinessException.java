package io.github.fernanda.maia.product.exception;

import io.github.fernanda.maia.product.util.enums.ExceptionMessages;

public class BusinessException extends RuntimeException {

    public BusinessException(ExceptionMessages e) {
        super(e.getDescription());
    }
}
