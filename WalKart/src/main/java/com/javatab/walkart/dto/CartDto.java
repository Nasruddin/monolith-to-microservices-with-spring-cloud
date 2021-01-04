package com.javatab.walkart.dto;

import lombok.Value;

@Value
public class CartDto {
    Long id;
    Long customerId;
    String status;
}
