package com.example.spring_hibernate;

import com.example.spring_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            emp.setSalary(10000);
            emp.setDepartment("HR");

            session.createQuery("update Employee set salary = 0 where surname = 'Trenin'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
