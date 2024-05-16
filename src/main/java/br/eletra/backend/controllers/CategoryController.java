package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiOperation(value="Return new category")
    public CategoryEntity postCategoryEntity(@RequestBody CategoryEntity CategoryEntity) {
        return categoryRepository.save(CategoryEntity);
    }

    @PutMapping("/categories")
    @ResponseBody
    @ApiOperation(value="Update category")
    public String updateCategoryEntity(@RequestBody CategoryEntity CategoryEntity) {
        categoryRepository.save(CategoryEntity);
        return "Category updated";
    }

    @DeleteMapping("/categories/{category-name}")
    @ResponseBody
    @ApiOperation(value="Delete category")
    public String deleteCategoryEntity(@PathVariable(value = "category-name") String categoryName) {
        CategoryEntity CategoryEntity = categoryRepository.findByCategoryName(categoryName);
        categoryRepository.delete(CategoryEntity);
        return "Category deleted";
    }

    @GetMapping("/categories")
    @ResponseBody
    @ApiOperation(value="Return list of categories")
    public List<CategoryEntity> getCategoryEntityList() {
        return categoryRepository.findAll();
    }
}