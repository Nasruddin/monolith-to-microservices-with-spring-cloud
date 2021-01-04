package com.javatab.walkart.exception;

public class ILegalCartCreationException extends RuntimeException {

    public ILegalCartCreationException(String customerId) {
        super("Already active cart exist for customer " + customerId);
    }
}
