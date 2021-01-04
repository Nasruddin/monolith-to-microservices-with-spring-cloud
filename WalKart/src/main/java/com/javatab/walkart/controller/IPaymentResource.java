package com.javatab.walkart.controller;

import com.javatab.walkart.dto.PaymentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPaymentResource {

    @GetMapping
    List<PaymentDto> findAll();

    @GetMapping("/{id}")
    PaymentDto findById(@PathVariable Long id);

    @PostMapping
    PaymentDto create(@RequestBody PaymentDto orderItemDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
