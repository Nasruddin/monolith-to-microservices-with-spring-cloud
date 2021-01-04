package com.javatab.walkart.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class AddressDto {
    @NotBlank(message = "Address1 should be defined.")
    String address1;
    String address2;
    @NotBlank(message = "City should be defined.")
    String city;
    @NotBlank(message = "Postcode should be defined.")
    String postcode;
    @NotBlank(message = "Country should be defined.")
    String country;
}
