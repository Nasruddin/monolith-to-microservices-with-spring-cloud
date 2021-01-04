package com.javatab.walkart.controller;

import com.javatab.walkart.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICartResource {

    @GetMapping
    List<CartDto> findAll();

    @GetMapping("/active")
    List<CartDto> findAllActiveCarts();

    @GetMapping("/customer/{id}")
    CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId);

    @GetMapping("/{id}")
    CartDto findById(@PathVariable Long id);

    @PostMapping("/customer/{id}")
    CartDto create(@PathVariable("id") Long customerId);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
