package io.github.fernanda.maia.coupon.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.fernanda.maia.coupon.model.entity.Coupon;
import io.github.fernanda.maia.coupon.model.dto.CouponDTO;

@Mapper
public interface CouponMapper {

    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

    Coupon toModel(CouponDTO couponDTO);
    CouponDTO toDTO(Coupon coupon);
}
