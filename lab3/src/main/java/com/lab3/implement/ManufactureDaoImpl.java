package com.lab3.implement;

import com.lab3.Dao.ManufactureDao;
import com.lab3.POJO.Manufacture;
import com.lab3.POJO.Phone;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import javax.persistence.Parameter;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ManufactureDaoImpl implements ManufactureDao {
    public static ManufactureDaoImpl getInstance(){
        return  new ManufactureDaoImpl();
    }
    @Override

    public boolean add(Manufacture p) {

        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try {

            session.save(p);
            t.commit();

            session.close();

            return  true;


        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
            session.close();
            return true;
        }
    }

    @Override
    public Manufacture get(String id) {
        Session session = HibernateUtils.getFactory().openSession();

        try{
            Manufacture obj = session.get(Manufacture.class,id);
            return  obj;
        }catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List<Manufacture> getAll() {
        Session session = HibernateUtils.getFactory().openSession();
        Query query =  session.createQuery("from Manufacture");
        List<Manufacture> manufactures = query.getResultList();
        return  manufactures;
    }

    @Override
    public boolean remove(Manufacture p) {
        Session session = HibernateUtils.getFactory().openSession();
        Transaction tx = session.beginTransaction();;
        try {



            session.delete(p);
            tx.commit();

            session.close();
            return  true;
        } catch (HibernateException e) {
            if (tx != null)

                tx.rollback();
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean remove(String id) {
        Session session = HibernateUtils.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = (Transaction) session.beginTransaction();
            Manufacture sv = (Manufacture) session.get(Manufacture.class, id);

            session.delete(sv);
            tx.commit();

            session.close();
            return  true;
        } catch (HibernateException e) {
            if (tx != null)

                tx.rollback();
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean update(Manufacture p) {
        Session session = HibernateUtils.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = (Transaction) session.beginTransaction();


            session.update(p);
            tx.commit();

            session.close();
            return  true;
        } catch (HibernateException e) {
            if (tx != null)

                tx.rollback();
            e.printStackTrace();
            return  false;
        }
    }
    public List<Manufacture> getManufactureEmployee(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Manufacture where Employee > 100");
            List<Manufacture> result =  query.getResultList();

            return  result;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }
    public Long getNumberEmpoloyee(String name){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        Long result = null;
        try{
            Query query = session.createQuery("select Sum(Employee) from Manufacture where Name Like \'%"+name +"%\'");
            result = (Long) query.getResultList().get(0);



                return result;

        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }

    public  Manufacture getManufacturewithcondition(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Manufacture where Location ='US'");
         List<Manufacture>  result = query.getResultList();



            return result.get(result.size()-1);

        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;

    }
}
