package org.example.dao;

import org.example.config.HibernateUtil;
import org.example.dao.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public void delete(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}
