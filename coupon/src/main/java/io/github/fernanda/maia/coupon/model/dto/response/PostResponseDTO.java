package io.github.fernanda.maia.coupon.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {
    private UUID uuid;
    private String message;
}
