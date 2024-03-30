package com.example.security.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDtoRequest {
    private String name;
    private String description;
    private Long categoryId;
    private int quantity;
    private double price;
}
