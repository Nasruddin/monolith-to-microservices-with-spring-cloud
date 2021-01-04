package com.javatab.walkart.service;

import com.javatab.walkart.domain.Order;
import com.javatab.walkart.domain.Payment;
import com.javatab.walkart.domain.enumeration.PaymentStatus;
import com.javatab.walkart.repository.OrderRepository;
import com.javatab.walkart.repository.PaymentRepository;
import com.javatab.walkart.dto.PaymentDto;
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
public class PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public static PaymentDto mapToDto(Payment payment) {
        if (payment != null) {
            return new PaymentDto(
                    payment.getId(),
                    payment.getPaypalPaymentId(),
                    payment.getStatus().name(),
                    payment.getOrder().getId()
            );
        }
        return null;
    }

    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
                .stream()
                .map(PaymentService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository
                .findById(id)
                .map(PaymentService::mapToDto)
                .orElse(null);
    }

    public PaymentDto create(PaymentDto paymentDto) {
        log.debug("Request to create Payment : {}", paymentDto);

        Order order =
                this.orderRepository
                        .findById(paymentDto.getOrderId())
                        .orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        return mapToDto(this.paymentRepository.save(
                new Payment(
                        paymentDto.getPaypalPaymentId(),
                        PaymentStatus.valueOf(paymentDto.getStatus()),
                        order
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }
}
