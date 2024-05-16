package br.eletra.backend.repositories;

import br.eletra.backend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

    List<CategoryEntity> findByLineId(Short lineId);

    CategoryEntity findByCategoryName(String categoryName);

    void delete(CategoryEntity CategoryEntity);
}