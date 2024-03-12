package br.eletra.backend.services;

import br.eletra.backend.models.Line;
import br.eletra.backend.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    private final LineRepository lineRepository;

    @Autowired
    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }

    public Optional<Line> getLineById(Long id) {
        return lineRepository.findById(id);
    }

    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    public Line updateLine(Long id, Line line) {
        Optional<Line> existingLineOptional = lineRepository.findById(id);
        if (existingLineOptional.isPresent()) {
            Line existingLine = existingLineOptional.get();
            existingLine.setName(line.getName()); // Assuming you want to update the name only
            return lineRepository.save(existingLine);
        } else {
            // Handle the case where the line with the given id doesn't exist
            return null;
        }
    }
}
