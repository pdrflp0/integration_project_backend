package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ModelServices ModelServices;

    @GetMapping("/models/{category-name}")
    @ResponseBody
    @ApiOperation(value="Return model")
    public List<ModelEntity> getModelEntity(@PathVariable(value="category-name") String categoryName) {
        List<ModelEntity> list = ModelServices.getModelNameByCategoryName(categoryName);
        return list;
    }

    @PostMapping("/models")
    @ResponseBody
    @ApiOperation(value="Return model")
    public ModelEntity postModelEntity(@RequestBody ModelEntity ModelEntity) {
        return modelRepository.save(ModelEntity);
    }

    @PutMapping("/models")
    @ResponseBody
    @ApiOperation(value="Update model")
    public ModelEntity updateModelEntity(@RequestBody ModelEntity ModelEntity) {
        return modelRepository.save(ModelEntity);
    }

    @DeleteMapping("/models/{model-name}")
    @ResponseBody
    @ApiOperation(value="Delete model")
    public boolean deleteModelEntity(@PathVariable(value = "model-name") String modelName) {
        ModelEntity ModelEntity = modelRepository.findByModelName(modelName);
        if (ModelEntity != null) {
            modelRepository.delete(ModelEntity);
            return modelRepository.findByModelName(modelName) == null;
        }
        return false;
    }

    @GetMapping("/models")
    @ResponseBody
    @ApiOperation(value="Return list of models")
    public List<ModelEntity> getModelEntityList() {
        return modelRepository.findAll();
    }
}