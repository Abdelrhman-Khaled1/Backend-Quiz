package com.example.security.sale.orderline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ProductOrderLineDtoRequest {
    private Long product_id;
    private int quantity;
}
