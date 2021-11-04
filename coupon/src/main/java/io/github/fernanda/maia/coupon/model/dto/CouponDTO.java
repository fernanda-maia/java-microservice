package io.github.fernanda.maia.coupon.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    private Long id;

    @NotEmpty
    @Size(min = 6, max = 6)
    private String code;

    @NotEmpty
    private BigDecimal discount;

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
}
