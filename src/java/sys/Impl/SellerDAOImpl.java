package sys.Impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.SellerDAO;
import sys.model.Vendedor;
import sys.util.HibernateUtil;

public class SellerDAOImpl implements SellerDAO{

    @Override
    public List<Vendedor> select() {
        List<Vendedor> vendedores = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Vendedor";
        try {
            vendedores = session.createQuery(hql).list();
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
        return vendedores;
    }

    @Override
    public void insert(Vendedor vendedor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vendedor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Vendedor vendedor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vendedor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Vendedor vendedor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vendedor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    
}
