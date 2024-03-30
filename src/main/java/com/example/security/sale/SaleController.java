package com.example.security.sale;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<?> AddSale(@RequestBody SaleOperationDtoRequest saleOperationDtoRequest){
        saleService.save(saleOperationDtoRequest);
        return ResponseEntity.accepted().build();
    }

}
