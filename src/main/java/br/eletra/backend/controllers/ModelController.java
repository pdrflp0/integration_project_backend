package br.eletra.backend.controllers;

import br.eletra.backend.models.Model;
import br.eletra.backend.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<Model>> getAllModels() {
        List<Model> models = modelService.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Long id) {
        Optional<Model> optionalModel = modelService.getModelById(id);
        return optionalModel.map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Model> createModel(@RequestBody Model model) {
        Model createdModel = modelService.createModel(model);
        return new ResponseEntity<>(createdModel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Long id, @RequestBody Model model) {
        Model updatedModel = modelService.updateModel(id, model);
        if (updatedModel != null) {
            return new ResponseEntity<>(updatedModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
