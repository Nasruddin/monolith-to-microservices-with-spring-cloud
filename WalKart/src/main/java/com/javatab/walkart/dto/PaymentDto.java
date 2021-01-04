package com.javatab.walkart.dto;

import lombok.Value;

@Value
public class PaymentDto {
    Long id;
    String paypalPaymentId;
    String status;
    Long orderId;
}
