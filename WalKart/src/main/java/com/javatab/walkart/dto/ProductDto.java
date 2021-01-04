package com.javatab.walkart.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@Value
public class ProductDto {
    Long id;
    @NotBlank(message = "Product name should be defined.")
    String name;
    String description;
    BigDecimal price;
    String status;
    Integer salesCounter;
    Set<ReviewDto> reviews;
    Long categoryId;
}
