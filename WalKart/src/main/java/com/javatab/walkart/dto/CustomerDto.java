package com.javatab.walkart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class CustomerDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String telephone;
}
