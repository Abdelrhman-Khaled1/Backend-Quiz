package com.example.security.sale;

import com.example.security.sale.orderline.ProductOrderLineDtoRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaleOperationDtoRequest {

    private Long client_id;
    private List<ProductOrderLineDtoRequest> productsList;

}


