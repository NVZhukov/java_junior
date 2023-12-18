package ru.geekbrains.hw4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao {

    public CourseDao() {
    }

    public Course findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Course.class, id);
    }

    public void saveData(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(course);
        t.commit();
        session.close();
    }

    public void updateData(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(course);
        t.commit();
        session.close();
    }

    public void deleteData(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(course);
        t.commit();
        session.close();
    }

    public List<Course> findAll() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Course", Course.class).list();
    }
}
