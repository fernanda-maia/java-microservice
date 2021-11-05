package io.github.fernanda.maia.coupon.exception;

import io.github.fernanda.maia.coupon.util.MessageUtil;

public class BusinessException extends RuntimeException {

    public BusinessException(MessageUtil message, String code) {
        super(message.getDescription() + code);
    }
}
