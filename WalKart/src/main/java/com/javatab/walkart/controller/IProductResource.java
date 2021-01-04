package com.javatab.walkart.controller;

import com.javatab.walkart.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IProductResource {

    @GetMapping
    List<ProductDto> findAll();

    @GetMapping("/{id}")
    ProductDto findById(@PathVariable Long id);

    @PostMapping
    ProductDto create(@Valid @RequestBody ProductDto productDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
