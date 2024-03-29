package com.example.security.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void save(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).get();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }
}
