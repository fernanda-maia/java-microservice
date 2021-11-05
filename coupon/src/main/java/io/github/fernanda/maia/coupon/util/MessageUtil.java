package io.github.fernanda.maia.coupon.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageUtil {

    COUPON_NOT_FOUND("Could not find the coupon!"),
    CODE_CANNOT_CHANGE("Coupon cannot be changed!"),
    COUPON_ALREADY_REGISTERED("Coupon code already registered!");

    private final String description;
}
