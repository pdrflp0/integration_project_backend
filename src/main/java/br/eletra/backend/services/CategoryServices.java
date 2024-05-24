package br.eletra.backend.services;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LineServices LineServices;

    public List<CategoryEntity> getCategoriesByLineName(String lineName) {
        Short lineId = LineServices.getLineIdByLineName(lineName);
        return categoryRepository.findByLineId(lineId);
    }

    public Short getCategoryIdByCategoryName(String categoryName) {
        CategoryEntity Category = categoryRepository.findByCategoryName(categoryName);
        return Category.getId();
    }
}
