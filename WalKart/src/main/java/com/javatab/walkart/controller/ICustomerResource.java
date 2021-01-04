package com.javatab.walkart.controller;

import com.javatab.walkart.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICustomerResource {

    @GetMapping
    List<CustomerDto> findAll();

    @GetMapping("/{id}")
    CustomerDto findById(@PathVariable Long id);

    @GetMapping("/active")
    List<CustomerDto> findAllActive();

    @GetMapping("/inactive")
    List<CustomerDto> findAllInactive();

    @PostMapping
    CustomerDto create(CustomerDto customerDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
