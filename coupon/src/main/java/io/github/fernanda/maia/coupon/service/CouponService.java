package io.github.fernanda.maia.coupon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.transaction.annotation.Transactional;

import io.github.fernanda.maia.coupon.util.MessageUtil;
import io.github.fernanda.maia.coupon.model.entity.Coupon;
import io.github.fernanda.maia.coupon.model.mapper.CouponMapper;
import io.github.fernanda.maia.coupon.exception.BusinessException;
import io.github.fernanda.maia.coupon.model.dto.request.CouponDTO;
import io.github.fernanda.maia.coupon.repository.CouponRepository;
import io.github.fernanda.maia.coupon.exception.CouponNotFoundException;
import io.github.fernanda.maia.coupon.model.dto.response.PostResponseDTO;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository repository;
    private final CouponMapper mapper = CouponMapper.INSTANCE;

    @Transactional(readOnly = true)
    public List<CouponDTO> findAllCoupons(CouponDTO dtoFilter) {
        List<CouponDTO> couponDTOList = new ArrayList<>();

        if(dtoFilter != null) {
            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                    .withIgnoreCase()
                    .withIgnoreNullValues()
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

            Coupon couponFilter = this.mapper.toModel(dtoFilter);
            Example<Coupon> example = Example.of(couponFilter, matcher);

            List<Coupon> couponList = this.repository.findAll(example);
            couponDTOList = this.mapper.toDTO(couponList);

        } else {
            couponDTOList = this.mapper.toDTO(this.repository.findAll());
        }

        return couponDTOList;
    }

    @Transactional(readOnly = true)
    public CouponDTO findByUUID(UUID uuid) {
        Optional<Coupon> optional = this.repository.findById(uuid);

        if(optional.isEmpty()) {
            throw new CouponNotFoundException();
        }

        return this.mapper.toDTO(optional.get());
    }

    @Transactional(readOnly = false)
    public PostResponseDTO saveCoupon(CouponDTO couponDTO) {
        Optional<Coupon> isCodeRegistered = this.repository.findByCode(couponDTO.getCode());

        if(isCodeRegistered.isPresent()) {
            throw new BusinessException(MessageUtil.COUPON_ALREADY_REGISTERED, couponDTO.getCode());
        }

        Coupon saveCoupon = this.mapper.toModel(couponDTO);
        this.repository.save(saveCoupon);

        return new PostResponseDTO(saveCoupon.getUuid(), "Coupon Created Successfully!");
    }

    @Transactional(readOnly = false)
    public PostResponseDTO updateCoupon(UUID uuid, CouponDTO couponDTO) {
        Optional<Coupon> foundUUID = this.repository.findById(uuid);

        if(foundUUID.isEmpty()) {
            throw new CouponNotFoundException();
        }

        String code = foundUUID.get().getCode();

        if(!code.equals(couponDTO.getCode())) {
            throw new BusinessException(MessageUtil.CODE_CANNOT_CHANGE, code);
        }

        couponDTO.setUuid(uuid);
        this.repository.save(this.mapper.toModel(couponDTO));

        return new PostResponseDTO(uuid, "Coupon Updated Successfully!");
    }
}
