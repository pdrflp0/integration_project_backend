package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.eletra.backend.entity.ModelEntity;
import br.eletra.backend.repositories.ModelRepository;
import br.eletra.backend.services.ModelServices;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST")
@CrossOrigin(origins="*")
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelServices modelServices;

    @GetMapping("/models/{category-name}")
    @ResponseBody
    @ApiOperation(value="Return model")
    public List<ModelEntity> getModelEntity(@PathVariable(value="category-name") String categoryName) {
        List<ModelEntity> list = modelServices.getModelNameByCategoryName(categoryName);
        return list;
    }

    @PostMapping("/models")
    @ResponseBody
    @ApiOperation(value="Return model")
    public ModelEntity postModelEntity(@RequestBody ModelEntity modelEntity) {
        return modelRepository.save(modelEntity);
    }

    @PutMapping("/models")
    @ResponseBody
    @ApiOperation(value="Update model")
    public ModelEntity updateModelEntity(@RequestBody ModelEntity modelEntity) {
        return modelRepository.save(modelEntity);
    }

    @DeleteMapping("/models/{model-name}")
    @ResponseBody
    @ApiOperation(value="Delete a model")
    public ResponseEntity<Boolean> deleteModelEntity(@PathVariable(value = "model-name") String modelName) {
        ModelEntity modelEntity = modelRepository.findByModelName(modelName);
        if (modelEntity != null) {
            modelRepository.delete(modelEntity);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(404).body(false);
    }

    @GetMapping("/models")
    @ResponseBody
    @ApiOperation(value="Return list of models")
    public List<ModelEntity> getModelEntityList() {
        return modelRepository.findAll();
    }
}
