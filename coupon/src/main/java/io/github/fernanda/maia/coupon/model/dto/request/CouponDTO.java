package io.github.fernanda.maia.coupon.model.request.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.UUID;
import java.time.LocalDate;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    private UUID uuid;

    @NotEmpty
    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    private BigDecimal discount;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
}
