package implement;

import DAO.ProductDAO;
import POJO.Login;
import POJO.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ProductImplement implements ProductDAO {
    @Override
    public List<Product> getAll() {
        Session session = HibernateUtils.getFactory().openSession();
        Query query =  session.createQuery("from Product");
        List<Product> ProductList = query.getResultList();
        return  ProductList;
    }
    public boolean delete(int ma){
        Transaction t = null;
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();

            t = session.beginTransaction();

            Product product = (Product) session.get(Product.class, ma);
            session.delete(product);
            t.commit();
            session.close();
            return true;

        }catch (HibernateException e){
            e.printStackTrace();
            t.rollback();
            session.close();

            return false;


        }}


    @Override
    public boolean add(Product product) {
        Transaction t = null;
        Session session = null;
        try {
                 session = HibernateUtils.getFactory().openSession();

                 t = session.beginTransaction();
                session.save(product);

                t.commit();
                session.close();
                return true;

            }catch (HibernateException e){
                e.printStackTrace();
                t.rollback();
                session.close();

                return false;


        }}

    public static ProductImplement getInstance() {
        return new ProductImplement();
    }

}
