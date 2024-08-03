package org.example.dao;

import org.example.config.HibernateUtil;
import org.example.dao.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("from Planet where id = :id", Planet.class).setParameter("id", id).uniqueResult();
        }
    }

    public void update(Planet planet) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }

    public void delete(Planet planet) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }
}
