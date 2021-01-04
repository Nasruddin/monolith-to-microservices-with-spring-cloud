package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.IOrderResource;
import com.javatab.walkart.dto.OrderDto;
import com.javatab.walkart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/orders")
public class OrderResourceV1 extends BaseController implements IOrderResource {

    private final OrderService orderService;

    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    public List<OrderDto> findAllByUser(Long id) {
        return this.orderService.findAllByUser(id);
    }

    public OrderDto findById(Long id) {
        return this.orderService.findById(id);
    }

    public void delete(Long id) {
        this.orderService.delete(id);
    }
}
