package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.IProductResource;
import com.javatab.walkart.dto.ProductDto;
import com.javatab.walkart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/products")
public class ProductResourceV1 extends BaseController implements IProductResource {

    private final ProductService productService;

    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }

    public ProductDto findById(Long id) {
        return this.productService.findById(id);
    }

    public ProductDto create(ProductDto productDto) {
        return this.productService.create(productDto);
    }

    public void delete(Long id) {
        this.productService.delete(id);
    }
}
