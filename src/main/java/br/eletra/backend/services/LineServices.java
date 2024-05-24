package br.eletra.backend.services;

import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineServices {

    @Autowired
    private LineRepository lineRepository;

    public Short getLineIdByLineName(String lineName) {
        LineEntity LineEntity = lineRepository.findByLineName(lineName);
        return LineEntity.getId();
    }

}