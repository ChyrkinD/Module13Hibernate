package org.example.dao;

import lombok.NoArgsConstructor;
import org.example.config.HibernateUtil;
import org.example.dao.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Client findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public void delete(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}
