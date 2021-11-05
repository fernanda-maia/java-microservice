package io.github.fernanda.maia.coupon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.github.fernanda.maia.coupon.service.CouponService;
import io.github.fernanda.maia.coupon.model.dto.request.CouponDTO;
import io.github.fernanda.maia.coupon.model.dto.response.PostResponseDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostResponseDTO save(@RequestBody @Valid CouponDTO couponDTO) {
        return this.service.saveCoupon(couponDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<CouponDTO> findAll(CouponDTO filter) {
        return this.service.findAllCoupons(filter);
    }

    @GetMapping(path = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public CouponDTO findByUUID(@PathVariable UUID uuid) {
        return this.service.findByUUID(uuid);
    }

    @PutMapping(path = "/{uuid}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PostResponseDTO update(@PathVariable UUID uuid,
                                  @RequestBody @Valid CouponDTO couponDTO) {
        return this.service.updateCoupon(uuid, couponDTO);
    }

}
