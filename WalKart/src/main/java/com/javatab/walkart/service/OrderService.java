package com.javatab.walkart.service;

import com.javatab.walkart.domain.Address;
import com.javatab.walkart.domain.Cart;
import com.javatab.walkart.domain.Order;
import com.javatab.walkart.domain.enumeration.OrderStatus;
import com.javatab.walkart.repository.OrderRepository;
import com.javatab.walkart.dto.OrderDto;
import com.javatab.walkart.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public static OrderDto mapToDto(Order order) {
        if (order != null) {

            Set<OrderItemDto> orderItems = order
                    .getOrderItems()
                    .stream()
                    .map(OrderItemService::mapToDto)
                    .collect(Collectors.toSet());

            return new OrderDto(
                    order.getId(),
                    order.getTotalPrice(),
                    order.getStatus().name(),
                    order.getShipped(),
                    order.getPayment().getId(),
                    AddressService.mapToDto(order.getShipmentAddress()),
                    orderItems
            );
        }
        return null;
    }

    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Order : {}", id);
        return this.orderRepository.findById(id).map(OrderService::mapToDto).orElse(null);
    }

    public List<OrderDto> findAllByUser(Long id) {
        return this.orderRepository.findByCartCustomer_Id(id)
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    public OrderDto create(OrderDto orderDto) {
        log.debug("Request to create Order : {}", orderDto);
        return mapToDto(
                this.orderRepository.save(
                        new Order(
                                BigDecimal.ZERO,
                                OrderStatus.CREATION,
                                null,
                                null,
                                AddressService.createFromDto(orderDto.getShipmentAddress()),
                                Collections.emptySet(),
                                null
                        )
                )
        );
    }

    public Order create(Cart cart, Address address) {
        log.debug("Request to create Order with a Cart : {}", cart);
        return this.orderRepository.save(
                new Order(
                        BigDecimal.ZERO,
                        OrderStatus.CREATION,
                        null,
                        null,
                        address,
                        Collections.emptySet(),
                        cart
                )
        );
    }

    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }
}
