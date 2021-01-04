package com.javatab.walkart.dto;

import lombok.Value;

@Value
public class OrderItemDto {
    Long id;
    Long quantity;
    Long productId;
    Long orderId;
}
