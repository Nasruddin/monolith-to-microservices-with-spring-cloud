package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.ICategoryResource;
import com.javatab.walkart.dto.CategoryDto;
import com.javatab.walkart.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/categories")
public class CategoryResourceV1 extends BaseController implements ICategoryResource {

    private final CategoryService categoryService;

    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }

    public CategoryDto findById(Long id) {
        return this.categoryService.findById(id);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto);
    }

    public void delete(Long id) {
        this.categoryService.delete(id);
    }
}
