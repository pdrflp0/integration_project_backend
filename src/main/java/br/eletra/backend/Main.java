package br.eletra.backend;

import br.eletra.backend.dao.ModelDAO;
import br.eletra.backend.models.ModelEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            ModelDAO modelDAO = new ModelDAO(sessionFactory);

            ModelEntity modelEntity = new ModelEntity();
            modelEntity.setName("Exemplo de Modelo");
            modelDAO.saveModel(modelEntity);

            logger.info("Todos os modelos:");
            modelDAO.getAllModels().forEach(m -> logger.info(m.getName()));

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
