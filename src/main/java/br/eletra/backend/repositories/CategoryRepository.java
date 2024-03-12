package br.eletra.backend.repositories;

import br.eletra.backend.models.Category;
import br.eletra.backend.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByModel(Model model);
}
