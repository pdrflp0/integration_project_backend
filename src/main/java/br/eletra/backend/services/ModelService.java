package br.eletra.backend.services;

import br.eletra.backend.models.Model;
import br.eletra.backend.repositories.ModelRepository;
import br.eletra.backend.models.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    public Model updateModel(Long id, Model model) {
        Optional<Model> existingModelOptional = modelRepository.findById(id);
        if (existingModelOptional.isPresent()) {
            Model existingModel = existingModelOptional.get();
            existingModel.setName(model.getName());
            return modelRepository.save(existingModel);
        } else {
            return null;
        }
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    public List<Model> getModelsByLine(Line line) {
        return modelRepository.findByLine(line);
    }
}
