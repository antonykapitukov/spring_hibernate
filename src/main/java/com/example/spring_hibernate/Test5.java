package com.example.spring_hibernate;

import com.example.spring_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);

            // session.delete(employee);
            session.remove(employee);

            session.createQuery("delete Employee where id > 9").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
