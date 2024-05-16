package br.eletra.backend.repositories;

import br.eletra.backend.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, String> {

    ModelEntity findByModelName(String modelName);

    List<ModelEntity> findByCategoryId(Short categoryId);

    void delete(ModelEntity ModelEntity);
}