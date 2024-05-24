package br.eletra.backend.repositories;

import br.eletra.backend.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, String> {

    LineEntity findByLineName(String lineName);

    void delete(LineEntity LineEntity);
}