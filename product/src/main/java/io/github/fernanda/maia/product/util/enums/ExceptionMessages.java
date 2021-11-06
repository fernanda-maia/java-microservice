package io.github.fernanda.maia.product.util.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_NOT_FOUND("COULD NOT FOUND THE PRODUCT"),
    CODE_ALREADY_REGISTERED("CODE ALREADY REGISTERED");

    private final String description;
}
