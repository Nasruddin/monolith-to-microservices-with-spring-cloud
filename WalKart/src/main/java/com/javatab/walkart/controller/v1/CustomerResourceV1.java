package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.ICustomerResource;
import com.javatab.walkart.dto.CustomerDto;
import com.javatab.walkart.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/customers")
public class CustomerResourceV1 extends BaseController implements ICustomerResource {

    private final CustomerService customerService;

    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

    public CustomerDto findById(Long id) {
        return this.customerService.findById(id);
    }

    public List<CustomerDto> findAllActive() {
        return this.customerService.findAllActive();
    }

    public List<CustomerDto> findAllInactive() {
        return this.customerService.findAllInactive();
    }

    public CustomerDto create(CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    public void delete(Long id) {
        this.customerService.delete(id);
    }
}
