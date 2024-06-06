package br.eletra.backend.services;

import br.eletra.backend.entity.ModelEntity;
import br.eletra.backend.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServices {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private CategoryServices CategoryServices;

    public List<ModelEntity> getModelNameByCategoryName(String categoryName) {
        Short categoryId = CategoryServices.getCategoryIdByCategoryName(categoryName);
        return modelRepository.findByCategoryId(categoryId);
    }
}