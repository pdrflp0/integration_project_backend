package br.eletra.backend.repositories;

import br.eletra.backend.models.Model;
import br.eletra.backend.models.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByLine(Line line);
}
