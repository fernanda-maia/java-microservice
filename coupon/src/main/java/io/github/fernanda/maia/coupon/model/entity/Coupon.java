package io.github.fernanda.maia.coupon.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_coupon")
public class Coupon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    @NaturalId
    @Column(nullable = false, unique = true, length = 6)
    private String code;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDate.now();
    }
}
