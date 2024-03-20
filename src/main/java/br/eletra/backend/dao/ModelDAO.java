package br.eletra.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.eletra.backend.models.ModelEntity;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class ModelDAO {

    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(ModelDAO.class);

    @Autowired
    public ModelDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<ModelEntity> getAllModels() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ModelEntity", ModelEntity.class).getResultList();
    }

    @Transactional
    public void saveModel(ModelEntity modelEntity) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(modelEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Erro ao salvar modelo", e);
        }
    }
}
