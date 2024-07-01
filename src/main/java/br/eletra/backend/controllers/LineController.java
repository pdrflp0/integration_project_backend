package br.eletra.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "Return line")
    public LineEntity getLineEntity(@PathVariable(value = "line-name") String lineName) {
        return lineRepository.findByLineName(lineName);
    }

    @PostMapping("/lines")
    @ResponseBody
    @ApiOperation(value = "Return line")
    public LineEntity postLineEntity(@RequestBody LineEntity LineEntity) {
        return lineRepository.save(LineEntity);
    }

    @PutMapping("/lines")
    @ResponseBody
    @ApiOperation(value = "Update line")
    public LineEntity updateLineEntity(@RequestBody LineEntity LineEntity) {
        return lineRepository.save(LineEntity);
    }

    @DeleteMapping("/lines/{line-name}")
    @ResponseBody
    @ApiOperation(value = "Delete a line")
    public ResponseEntity<Boolean> deleteLineEntity(@PathVariable(value = "line-name") String lineName) {
        LineEntity lineEntity = lineRepository.findByLineName(lineName);
        if (lineEntity != null) {
            lineRepository.delete(lineEntity);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @GetMapping("/lines")
    @ResponseBody
    @ApiOperation(value="Return list of lines")
    public List<LineEntity> getLineEntityList() {
        return lineRepository.findAll();
    }
}