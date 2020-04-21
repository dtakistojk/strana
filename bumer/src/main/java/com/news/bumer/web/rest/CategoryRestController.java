package com.news.bumer.web.rest;

import com.news.bumer.model.Category;
import com.news.bumer.service.CategoryService;
import com.news.bumer.service.MapValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/categories", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class CategoryRestController {

    private final CategoryService categoryService;
    private final MapValidationErrorService mapValidationErrorService;

    public CategoryRestController(CategoryService categoryService, MapValidationErrorService mapValidationErrorService) {
        this.categoryService = categoryService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategory(){
        return this.categoryService.getAllCategory();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createCategory(@Valid @RequestBody Category category, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        return this.categoryService.save(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> getCategory(@PathVariable long id){
        return this.categoryService.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(@PathVariable long id,
                                   @RequestBody Category category){
        category.setId(id);
        return this.categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable long id){
        this.categoryService.deleteCategory(id);
    }

}