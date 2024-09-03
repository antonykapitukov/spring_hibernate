package com.example.spring_hibernate;

import com.example.spring_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Anton", "Kapshukov", "IT", 5000);

            session.beginTransaction();

            // session.save(employee);
            session.persist(employee);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
