package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.repositories.CategoryRepository;
import br.eletra.backend.services.CategoryServices;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST")
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServices CategoryServices;

    @GetMapping("/categories/{line-name}")
    @ResponseBody
    @ApiOperation(value="Return category")
    public List<CategoryEntity> getCategoriesByLine(@PathVariable(value="line-name") String lineName) {
        List<CategoryEntity> list = CategoryServices.getCategoriesByLineName(lineName);
        return list;
    }

    @PostMapping("/categories")
    @ResponseBody
    @ApiOperation(value="Return category")
    public CategoryEntity postCategoryEntity(@RequestBody CategoryEntity CategoryEntity) {
        return categoryRepository.save(CategoryEntity);
    }

    @PutMapping("/categories")
    @ResponseBody
    @ApiOperation(value="Update category")
    public CategoryEntity updateCategoryEntity(@RequestBody CategoryEntity CategoryEntity) {
        return categoryRepository.save(CategoryEntity);
    }

    @DeleteMapping("/categories/{category-name}")
    @ResponseBody
    @ApiOperation(value="Delete category")
    public ResponseEntity<Boolean> deleteCategoryEntity(@PathVariable(value = "category-name") String categoryName) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryName(categoryName);
        if (categoryEntity != null) {
            categoryRepository.delete(categoryEntity);
            boolean exists = categoryRepository.findByCategoryName(categoryName) != null;
            return ResponseEntity.ok(!exists);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @GetMapping("/categories")
    @ResponseBody
    @ApiOperation(value="Return list of categories")
    public List<CategoryEntity> getCategoryEntityList() {
        return categoryRepository.findAll();
    }
}