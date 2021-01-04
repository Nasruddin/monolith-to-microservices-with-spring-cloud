package com.javatab.walkart.service;

import com.javatab.walkart.domain.Order;
import com.javatab.walkart.domain.OrderItem;
import com.javatab.walkart.domain.Product;
import com.javatab.walkart.repository.OrderItemRepository;
import com.javatab.walkart.repository.OrderRepository;
import com.javatab.walkart.repository.ProductRepository;
import com.javatab.walkart.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderItemService {

    private final Logger log = LoggerFactory.getLogger(OrderItemService.class);

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if (orderItem != null) {
            return new OrderItemDto(
                    orderItem.getId(),
                    orderItem.getQuantity(),
                    orderItem.getProduct().getId(),
                    orderItem.getOrder().getId()
            );
        }
        return null;
    }

    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository.findById(id).map(OrderItemService::mapToDto).orElse(null);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);
        Order order =
                this.orderRepository
                        .findById(orderItemDto.getOrderId())
                        .orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        Product product =
                this.productRepository
                        .findById(orderItemDto.getProductId())
                        .orElseThrow(() -> new IllegalStateException("The Product does not exist!"));

        OrderItem orderItem = this.orderItemRepository.save(
                new OrderItem(
                        orderItemDto.getQuantity(),
                        product,
                        order
                ));

        order.setTotalPrice(
                order.getTotalPrice().add(orderItem.getProduct().getPrice())
        );

        this.orderRepository.save(order);

        return mapToDto(orderItem);
    }

    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }
}
