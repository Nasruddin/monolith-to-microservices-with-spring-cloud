package com.javatab.walkart.controller;

import com.javatab.walkart.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICategoryResource {

    @GetMapping
    List<CategoryDto> findAll();

    @GetMapping("/{id}")
    CategoryDto findById(@PathVariable Long id);

    @PostMapping
    CategoryDto create(@RequestBody CategoryDto categoryDto);

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id);
}
