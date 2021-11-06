package io.github.fernanda.maia.product.repository;

import io.github.fernanda.maia.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByCode(String code);
}
