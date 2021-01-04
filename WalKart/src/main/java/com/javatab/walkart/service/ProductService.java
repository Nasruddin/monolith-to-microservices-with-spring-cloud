package com.javatab.walkart.service;

import com.javatab.walkart.domain.Product;
import com.javatab.walkart.domain.Review;
import com.javatab.walkart.domain.enumeration.ProductStatus;
import com.javatab.walkart.repository.CategoryRepository;
import com.javatab.walkart.repository.ProductRepository;
import com.javatab.walkart.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public static ProductDto mapToDto(Product product) {
        if (product != null) {
            return new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStatus().name(),
                    product.getSalesCounter(),
                    product.getReviews().stream().map(ReviewService::mapToDto).collect(Collectors.toSet()),
                    product.getCategory().getId()
            );
        }
        return null;
    }

    public List<ProductDto> findAll() {
        log.debug("Request to get all Products");
        return this.productRepository.findAll()
                .stream()
                .map(ProductService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        log.debug("Request to get Product : {}", id);
        return this.productRepository.findById(id).map(ProductService::mapToDto).orElse(null);
    }

    public ProductDto create(ProductDto productDto) {
        log.debug("Request to create Product : {}", productDto);

        return mapToDto(this.productRepository.save(
                new Product(
                        productDto.getName(),
                        productDto.getDescription(),
                        productDto.getPrice(),
                        ProductStatus.valueOf(productDto.getStatus()),
                        productDto.getSalesCounter(),
                        Collections.emptySet(),
                        categoryRepository.findById(productDto.getCategoryId()).orElse(null)
                )));
    }

    public ProductDto addReview(Long productId, Review review) {
        Product product = this.productRepository
                .findById(productId)
                .orElseThrow(() -> new IllegalStateException("The Product does not exist!"));
        product.getReviews().add(review);
        this.productRepository.saveAndFlush(product);
        return mapToDto(product);
    }

    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        this.productRepository.deleteById(id);
    }
}
