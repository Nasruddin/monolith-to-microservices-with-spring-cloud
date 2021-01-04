package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.IOrderItemResource;
import com.javatab.walkart.dto.OrderItemDto;
import com.javatab.walkart.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/order-items")
public class OrderItemResourceV1 extends BaseController implements IOrderItemResource {

    private final OrderItemService itemService;

    public List<OrderItemDto> findAll() {
        return this.itemService.findAll();
    }

    public OrderItemDto findById(Long id) {
        return this.itemService.findById(id);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }

    public void delete(Long id) {
        this.itemService.delete(id);
    }
}
