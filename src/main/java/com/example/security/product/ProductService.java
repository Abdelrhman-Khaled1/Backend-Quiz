package com.example.security.product;

import com.example.security.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public void save(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .category(categoryService.findById(productRequest.getCategoryId()))
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
        product.setCategory(categoryService.findById(productRequest.getCategoryId()));
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }
}
