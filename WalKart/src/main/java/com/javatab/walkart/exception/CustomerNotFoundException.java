package com.javatab.walkart.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long customerId) {
        super("Customer with ID " + customerId + " doesn't exist");
    }
}
