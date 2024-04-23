package br.eletra.backend.dao;

import org.hibernate.Session;
import br.eletra.backend.entity.LineEntity;

import java.util.List;

public class LineDAO {

    private final Session session;

    public LineDAO(Session session) {
        this.session = session;
    }

    public List<LineEntity> getAllLines() {
        return session.createQuery("from LineEntity", LineEntity.class).getResultList();
    }

    public LineEntity getLineByName(String lineName) {
        return session.createQuery("from LineEntity where name = :lineName", LineEntity.class)
                .setParameter("lineName", lineName)
                .uniqueResult();
    }
}
