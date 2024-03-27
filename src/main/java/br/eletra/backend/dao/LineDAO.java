package br.eletra.backend.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.eletra.backend.entity.LineEntity;

import java.util.List;

@Repository
public class LineDAO {

    private final Session session;

    @Autowired
    public LineDAO(Session session) {
        this.session = session;
    }

    @Transactional
    public List<LineEntity> getAllLines() {
        return session.createQuery("from LineEntity", LineEntity.class).getResultList();
    }

    @Transactional
    public LineEntity getLineByName(String lineName) {
        return session.createQuery("from LineEntity where name = :lineName", LineEntity.class)
                .setParameter("lineName", lineName)
                .uniqueResult();
    }
}
