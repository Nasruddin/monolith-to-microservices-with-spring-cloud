package com.javatab.walkart.controller;

import com.javatab.walkart.dto.ReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IReviewResource {

    @GetMapping
    List<ReviewDto> findAll();

    @GetMapping("/{id}")
    ReviewDto findById(@PathVariable Long id);

    @PostMapping
    ReviewDto create(@RequestBody ReviewDto reviewDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
