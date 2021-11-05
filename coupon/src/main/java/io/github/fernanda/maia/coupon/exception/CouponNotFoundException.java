package io.github.fernanda.maia.coupon.exception;

import io.github.fernanda.maia.coupon.util.MessageUtil;

public class CouponNotFoundException extends RuntimeException{

    public CouponNotFoundException() {
        super(MessageUtil.COUPON_NOT_FOUND.getDescription());
    }
}
