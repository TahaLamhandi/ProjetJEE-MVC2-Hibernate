package dao;

import dao.Produit;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

public class ProduitImpl implements ProduitDAO {

    @Override
    public void addProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public List<Produit> getAllProduits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Produit");
        List<Produit> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Produit getProduitById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Produit p = (Produit) session.get(Produit.class, (long) id);
        session.close();
        return p;
    }

    @Override
    public void deleteProduit(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Produit p = (Produit) session.get(Produit.class, (long) id);
        if (p != null) {
            session.delete(p);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void updateProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }
}