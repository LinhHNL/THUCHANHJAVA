package implement;

import DAO.LoginDAO;
import POJO.Login;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginImplement implements LoginDAO {

    public static LoginImplement getInstance() {
        return new LoginImplement();
    }
    public Login get(String username){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            Login lg = (Login) session.get(Login.class, username);
            System.out.println(lg.getEmail());
            System.out.println(lg.getPassword());

            t.commit();
            session.close();
            return lg;

        }catch (HibernateException e){
            e.printStackTrace();
            t.rollback();
            session.close();

            return null;
        }

    }
    public boolean add(Login register){
        Session session = HibernateUtils.getFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            session.save(register);

            t.commit();
            session.close();
            return true;

        }catch (HibernateException e){
            e.printStackTrace();
            t.rollback();
            session.close();

            return false;
        }

    }
}