package io.github.fernanda.maia.coupon.repository;

import java.util.UUID;
import java.util.Optional;

import io.github.fernanda.maia.coupon.model.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
    Optional<Coupon> findByCode(String code);
}
