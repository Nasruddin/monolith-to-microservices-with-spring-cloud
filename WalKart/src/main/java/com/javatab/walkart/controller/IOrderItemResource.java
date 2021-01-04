package com.javatab.walkart.controller;


import com.javatab.walkart.dto.OrderItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderItemResource {

    @GetMapping
    List<OrderItemDto> findAll();

    @GetMapping("/{id}")
    OrderItemDto findById(@PathVariable Long id);

    @PostMapping
    OrderItemDto create(@RequestBody OrderItemDto orderItemDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
