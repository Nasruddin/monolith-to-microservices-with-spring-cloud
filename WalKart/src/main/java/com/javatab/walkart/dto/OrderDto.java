package com.javatab.walkart.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Value
public class OrderDto {
    Long id;
    BigDecimal totalPrice;
    String status;
    ZonedDateTime shipped;
    Long paymentId;
    AddressDto shipmentAddress;
    Set<OrderItemDto> orderItems;
}
