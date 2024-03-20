package br.eletra.backend.dao;

import br.eletra.backend.models.LineEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LineDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public LineDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveLine(LineEntity line) {
        Session session = sessionFactory.getCurrentSession();
        session.save(line);
    }

    public List<LineEntity> getAllLines() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LineEntity", LineEntity.class).getResultList();
    }

    public LineEntity getLineById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LineEntity.class, id);
    }

    public void updateLine(LineEntity line) {
        Session session = sessionFactory.getCurrentSession();
        session.update(line);
    }

    public void deleteLine(LineEntity line) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(line);
    }
}
