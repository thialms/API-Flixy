package br.com.flixy.service;

import br.com.flixy.entity.Category;
import br.com.flixy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
