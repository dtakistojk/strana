package com.news.bumer.service;

import com.news.bumer.model.Category;
import com.news.bumer.model.exception.InvalidCategoryException;
import com.news.bumer.model.exception.ObjectExistException;
import com.news.bumer.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        try {
            return this.categoryRepository.save(category);
        } catch (Exception e) {
            throw new ObjectExistException("Category already exist");
        }
    }

    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findById(long id) {
        return this.categoryRepository.findById(id);
    }

    public Category updateCategory(long id, String name) {

        try {
            Category category = this.categoryRepository.findById(id).get();
            category.setName(name);
            return this.categoryRepository.save(category);
        }catch (Exception e){
            throw new InvalidCategoryException("Category don't exist");
        }

    }

    public void deleteCategory(long id) {
        this.categoryRepository.deleteById(id);
    }
}
