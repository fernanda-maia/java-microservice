package io.github.fernanda.maia.product.model.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotEmpty
    private String code;

    @NotEmpty
    @Size(max = 150)
    private String name;

    @NotEmpty
    @Size(max = 255)
    private String description;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;
}
