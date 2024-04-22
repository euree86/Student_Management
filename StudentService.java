package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService {

    private final SessionFactory factory;


    public StudentService() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();

    }

    public void saveStudent(Student student) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();

    }


    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }
    public Student getStudent(int id) {
        Session session = factory.openSession();
        return session.get(Student.class, id);
    }


    public List<Student> getAllStudents() {
        Session session = factory.openSession();
        return session.createQuery("FROM Student", Student.class).list();
    }

    public void exit() throws InterruptedException {
        System.out.println("Exiting System");
        int i = 3;
        while (i != 0) {
            System.out.print("* ");
            Thread.sleep(1000);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Student Management System");
    }
}