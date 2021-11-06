package io.github.fernanda.maia.product.exception;

import io.github.fernanda.maia.product.util.enums.ExceptionMessages;

public class NotFoundException extends RuntimeException{

    public NotFoundException(ExceptionMessages e) {
        super(e.getDescription());
    }
}
