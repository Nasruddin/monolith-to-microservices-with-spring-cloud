package com.javatab.walkart.controller;

import com.javatab.walkart.dto.OrderDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface IOrderResource {

    @GetMapping
    List<OrderDto> findAll();

    @GetMapping("/customer/{id}")
    List<OrderDto> findAllByUser(@PathVariable Long id);

    @GetMapping("/{id}")
    OrderDto findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
