package com.javatab.walkart.dto;

import lombok.Value;

@Value
public class CategoryDto {
    Long id;
    String name;
    String description;
    Integer products;
}
