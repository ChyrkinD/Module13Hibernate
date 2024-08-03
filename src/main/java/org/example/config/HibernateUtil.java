package org.example.config;

import lombok.Getter;
import org.example.dao.model.Client;
import org.example.dao.model.Planet;
import org.example.dao.model.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
