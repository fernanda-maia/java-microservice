package io.github.fernanda.maia.product.controller;

import io.github.fernanda.maia.product.model.dto.request.ProductDTO;
import io.github.fernanda.maia.product.model.dto.response.CreateResponseDTO;
import io.github.fernanda.maia.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/products")
public class ProductController {

    private final ProductService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateResponseDTO save(@RequestBody @Valid ProductDTO productDTO) {
        return this.service.createProduct(productDTO);
    }

    @DeleteMapping(path = "/{uuid}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID uuid) {
        this.service.deleteByUUID(uuid);
    }

    @GetMapping(path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO findByCode(@PathVariable String code) {
        return this.service.getByCode(code);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> findAll(ProductDTO filter) {
        return this.service.getAll(filter);
    }
}
