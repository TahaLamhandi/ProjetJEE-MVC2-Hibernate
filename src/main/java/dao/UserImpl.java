package dao;

import dao.User;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

public class UserImpl implements UserDAO {

    @Override
    public User finduser(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User u where u.email = :email and u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public boolean checkifemailexist(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select count(*) from User u where u.email = :email");
        query.setParameter("email", email);
        Long count = (Long) query.uniqueResult();
        session.close();
        return count > 0;
    }

    @Override
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public List<User> findallusers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        session.close();
        return list;
    }
}