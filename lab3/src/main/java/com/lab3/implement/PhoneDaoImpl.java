package com.lab3.implement;

import com.lab3.Dao.PhoneDao;
import com.lab3.POJO.Phone;
import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import javax.persistence.Query;
import org.hibernate.Transaction;


import java.sql.ResultSet;
import java.util.List;


public class PhoneDaoImpl implements PhoneDao {
    public static PhoneDaoImpl getInstance(){
        return  new PhoneDaoImpl();
    }
    @Override
    public boolean add(Phone p) {

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
    public Phone get(String id) {

        Session session = HibernateUtils.getFactory().openSession();

        try{
            Phone obj = session.get(Phone.class,id);
            return  obj;
        }catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }



    }

    @Override
    public List<Phone> getAll() {
        Session session = HibernateUtils.getFactory().openSession();
        Query query =  session.createQuery("from Phone");
        List<Phone> phoneList = query.getResultList();
        return  phoneList;
    }

    @Override
    public boolean remove(Phone p) {
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
            Phone sv = (Phone) session.get(Phone.class, id);

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
    public boolean update(Phone p) {
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
    public  List<Phone> HighestSellingPrice(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Phone where Price = (select max(Price) from Phone)");
            List<Phone> result = query.getResultList();
            return  result;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }
    public  List<Phone> OrderPhone(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Phone order by Country asc , Price desc");
            List<Phone> result = query.getResultList();
            return  result;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }
    public  List<Phone> FindPhoneOver50M(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Phone where Price > 50000000");
            List<Phone> result = query.getResultList();
            return  result;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }
    public  Phone FindPhone(){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();
        try{
            Query query = session.createQuery("from Phone where Price > 150000 and color Like '%pink%'");
             List<Phone> result =  query.getResultList();
          if(result.size()>0){
              return result.get(0);
          }
            return  null;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return  null;
    }
}



