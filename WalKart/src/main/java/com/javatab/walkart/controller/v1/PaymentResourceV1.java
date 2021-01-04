package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.IPaymentResource;
import com.javatab.walkart.dto.PaymentDto;
import com.javatab.walkart.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/payments")
public class PaymentResourceV1 extends BaseController implements IPaymentResource {

    private final PaymentService paymentService;

    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    public PaymentDto findById(Long id) {
        return this.paymentService.findById(id);
    }

    public PaymentDto create(PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }

    public void delete(Long id) {
        this.paymentService.delete(id);
    }
}
