package io.github.fernanda.maia.product.service;

import io.github.fernanda.maia.product.exception.BusinessException;
import io.github.fernanda.maia.product.exception.NotFoundException;
import io.github.fernanda.maia.product.model.dto.request.ProductDTO;
import io.github.fernanda.maia.product.model.dto.response.CreateResponseDTO;
import io.github.fernanda.maia.product.model.entity.Product;
import io.github.fernanda.maia.product.util.enums.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import io.github.fernanda.maia.product.model.mapper.ProductMapper;
import io.github.fernanda.maia.product.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @Transactional(readOnly = false)
    public CreateResponseDTO createProduct(ProductDTO productDTO) {
        Optional<Product> foundProduct = this.repository.findByCode(productDTO.getCode());

        if(foundProduct.isPresent()) {
            throw new BusinessException(ExceptionMessages.CODE_ALREADY_REGISTERED);
        }

        Product productToSave = this.mapper.toModel(productDTO);
        this.repository.save(productToSave);

        return CreateResponseDTO.builder()
                .uuid(productToSave.getUuid())
                .message("Product Created Successfully!")
                .createdAt(LocalDate.now())
                .build();
    }

    @Transactional(readOnly = false)
    public void deleteByUUID(UUID uuid) {
        Optional<Product> optional = this.repository.findById(uuid);

        if(optional.isEmpty()) {
            throw new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND);
        }

        this.repository.deleteById(uuid);
    }

    @Transactional(readOnly = true)
    public ProductDTO getByCode(String code) {
        Optional<Product> optional = this.repository.findByCode(code);

        if(optional.isEmpty()) {
            throw new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND);
        }

        return this.mapper.toDTO(optional.get());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAll(ProductDTO dtoFilter) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        if(dtoFilter != null) {
            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                    .withIgnoreNullValues()
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

            Product productFilter = this.mapper.toModel(dtoFilter);
            Example<Product> example = Example.of(productFilter, matcher);

            List<Product> products = this.repository.findAll(example);
            productDTOS = this.mapper.toDTO(products);

        } else {
            productDTOS = this.mapper.toDTO(this.repository.findAll());
        }

        return productDTOS;
    }

}
