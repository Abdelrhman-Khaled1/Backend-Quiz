package com.example.security.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void save(CategoryDto categoryDto) {
        categoryRepository.save(
                Category.builder()
                        .name(categoryDto.getName())
                        .build());
    }


    public void update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).get();
        category.setName(categoryDto.getName());
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

}
