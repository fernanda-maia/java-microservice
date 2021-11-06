package io.github.fernanda.maia.product.model.mapper;

import io.github.fernanda.maia.product.model.dto.request.ProductDTO;
import io.github.fernanda.maia.product.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toModel(ProductDTO productDTO);
    List<ProductDTO> toDTO(List<Product> products);
}
