package br.eletra.backend.controllers;

import br.eletra.backend.models.Line;
import br.eletra.backend.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lines")
public class LineController {

    private final LineService lineService;

    @Autowired
    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping
    public ResponseEntity<List<Line>> getAllLines() {
        List<Line> lines = lineService.getAllLines();
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Line> getLineById(@PathVariable Long id) {
        Optional<Line> optionalLine = lineService.getLineById(id);
        return optionalLine.map(line -> new ResponseEntity<>(line, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Line> createLine(@RequestBody Line line) {
        Line createdLine = lineService.createLine(line);
        return new ResponseEntity<>(createdLine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Line> updateLine(@PathVariable Long id, @RequestBody Line line) {
        Line updatedLine = lineService.updateLine(id, line);
        if (updatedLine != null) {
            return new ResponseEntity<>(updatedLine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
