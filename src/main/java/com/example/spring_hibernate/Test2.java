package com.example.spring_hibernate;

import com.example.spring_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            int myId = 5;
            Session session2 = sessionFactory.getCurrentSession();
            session2.beginTransaction();
            Employee employee2 = session2.get(Employee.class, myId);
            session2.getTransaction().commit();
            System.out.println(employee2.toString());

        } finally {
            sessionFactory.close();
        }
    }
}
