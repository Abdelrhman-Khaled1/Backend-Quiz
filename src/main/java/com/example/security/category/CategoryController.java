package com.example.security.category;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody CategoryDto categoryDto){
        categoryService.update(id ,categoryDto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAll());
    }

}
