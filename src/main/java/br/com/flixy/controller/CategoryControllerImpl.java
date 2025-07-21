package br.com.flixy.controller;

import br.com.flixy.controller.request.CategoryRequest;
import br.com.flixy.controller.response.CategoryResponse;
import br.com.flixy.entity.Category;
import br.com.flixy.mapper.CategoryMapper;
import br.com.flixy.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flixy/category")
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request) {
        Category savedCategory = categoryService.save(CategoryMapper.toCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
