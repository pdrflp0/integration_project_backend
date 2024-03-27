package br.eletra.backend.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.eletra.backend.entity.ModelEntity;
import br.eletra.backend.entity.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class ModelDAO {

    private final Session session;
    private static final Logger logger = LoggerFactory.getLogger(ModelDAO.class);

    @Autowired
    public ModelDAO(Session session) {
        this.session = session;
    }

    @Transactional
    public List<ModelEntity> getAllModels() {
        return session.createQuery("from ModelEntity", ModelEntity.class).getResultList();
    }

    @Transactional
    public List<ModelEntity> getModelsByLine(String lineName) {
        return session.createQuery("from ModelEntity m where m.category.line.name = :lineName", ModelEntity.class)
                .setParameter("lineName", lineName)
                .getResultList();
    }

    @Transactional
    public List<ModelEntity> getModelsByCategory(CategoryEntity category) {
        return session.createQuery("select m from ModelEntity m where m.category = :category", ModelEntity.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Transactional
    public void saveModel(ModelEntity modelEntity) {
        try {
            session.save(modelEntity);
        } catch (Exception e) {
            logger.error("Erro ao salvar modelo", e);
        }
    }
}
