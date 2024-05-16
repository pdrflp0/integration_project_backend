package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.repositories.LineRepository;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST")
@CrossOrigin(origins="*")
public class LineController {

    @Autowired
    private LineRepository lineRepository;

    @GetMapping("/lines/{line-name}")
    @ResponseBody
    @ApiOperation(value="Return line")
    public LineEntity getLineEntity(@PathVariable(value="line-name") String lineName) {
        return lineRepository.findByLineName(lineName);
    }

    @PostMapping("/lines")
    @ResponseBody
    @ApiOperation(value="Return new line")
    public LineEntity postLineEntity(@RequestBody LineEntity LineEntity) {
        return lineRepository.save(LineEntity);
    }

    @PutMapping("/lines")
    @ResponseBody
    @ApiOperation(value="Update line")
    public String updateLineEntity(@RequestBody LineEntity LineEntity) {
        lineRepository.save(LineEntity);
        return "Line updated";
    }

    @DeleteMapping("/lines/{line-name}")
    @ResponseBody
    @ApiOperation(value="Delete line")
    public String deleteLineEntity(@PathVariable(value = "line-name") String lineName) {
        LineEntity LineEntity = lineRepository.findByLineName(lineName);
        lineRepository.delete(LineEntity);
        return "Line deleted";
    }

    @GetMapping("/lines")
    @ResponseBody
    @ApiOperation(value="Return list of lines")
    public List<LineEntity> getLineEntityList() {
        return lineRepository.findAll();
    }
}