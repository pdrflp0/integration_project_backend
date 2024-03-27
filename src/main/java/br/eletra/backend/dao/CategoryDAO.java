package br.eletra.backend.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.LineEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class CategoryDAO {

    private final Session session;
    private static final Logger logger = LoggerFactory.getLogger(CategoryDAO.class);

    @Autowired
    public CategoryDAO(Session session) {
        this.session = session;
    }

    @Transactional
    public List<CategoryEntity> getAllCategories() {
        return session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
    }

    @Transactional
    public List<CategoryEntity> getCategoriesByLine(LineEntity line) {
        return session.createQuery("select c from CategoryEntity c where c.line = :line", CategoryEntity.class)
                .setParameter("line", line)
                .getResultList();
    }
}
