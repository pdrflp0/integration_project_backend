package br.eletra.backend.dao;

import org.hibernate.Session;
import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.LineEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoryDAO {

    private final Session session;
    private static final Logger logger = LoggerFactory.getLogger(CategoryDAO.class);

    public CategoryDAO(Session session) {
        this.session = session;
    }

    public List<CategoryEntity> getAllCategories() {
        return session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
    }

    public List<CategoryEntity> getCategoriesByLine(LineEntity line) {
        return session.createQuery("select c from CategoryEntity c where c.line = :line", CategoryEntity.class)
                .setParameter("line", line)
                .getResultList();
    }
}
