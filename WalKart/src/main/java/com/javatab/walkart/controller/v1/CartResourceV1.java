package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.ICartResource;
import com.javatab.walkart.dto.CartDto;
import com.javatab.walkart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/carts")
public class CartResourceV1 extends BaseController implements ICartResource {

    private final CartService cartService;

    public List<CartDto> findAll() {
        return this.cartService.findAll();
    }

    public List<CartDto> findAllActiveCarts() {
        return this.cartService.findAllActiveCarts();
    }

    public CartDto getActiveCartForCustomer(Long customerId) {
        return this.cartService.getActiveCart(customerId);
    }

    public CartDto findById(Long id) {
        return this.cartService.findById(id);
    }

    public CartDto create(Long customerId) {
        return this.cartService.createDto(customerId);
    }
    
    public void delete(Long id) {
        this.cartService.delete(id);
    }
}
