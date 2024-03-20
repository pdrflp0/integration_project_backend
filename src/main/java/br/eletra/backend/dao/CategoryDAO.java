package br.eletra.backend.dao;

import br.eletra.backend.models.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCategory(CategoryEntity category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    public List<CategoryEntity> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
    }

    public CategoryEntity getCategoryById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CategoryEntity.class, id);
    }

    public void updateCategory(CategoryEntity category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    public void deleteCategory(CategoryEntity category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }
}
