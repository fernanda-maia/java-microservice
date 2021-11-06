package io.github.fernanda.maia.product.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateResponseDTO {

    @NotNull
    private UUID uuid;

    @NotEmpty
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
