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

    public void save(ProductDtoRequest productDtoRequest) {
        var product = Product.builder()
                .name(productDtoRequest.getName())
                .description(productDtoRequest.getDescription())
                .category(categoryService.findById(productDtoRequest.getCategoryId()))
                .quantity(productDtoRequest.getQuantity())
                .price(productDtoRequest.getPrice())
                .build();
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void update(Long id, ProductDtoRequest productDtoRequest) {
        Product product = productRepository.findById(id).get();
        product.setName(productDtoRequest.getName());
        product.setDescription(productDtoRequest.getDescription());
        product.setCategory(categoryService.findById(productDtoRequest.getCategoryId()));
        product.setQuantity(productDtoRequest.getQuantity());
        product.setPrice(productDtoRequest.getPrice());
        productRepository.save(product);
    }
}
