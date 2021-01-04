package com.javatab.walkart.dto;

import lombok.Value;

@Value
public class ReviewDto {
    Long id;
    String title;
    String description;
    Long rating;
}
