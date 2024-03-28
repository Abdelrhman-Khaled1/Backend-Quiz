package com.example.security.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductRequest productRequest){
        productService.save(productRequest);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody ProductRequest productRequest){
        productService.update   (id ,productRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

}
