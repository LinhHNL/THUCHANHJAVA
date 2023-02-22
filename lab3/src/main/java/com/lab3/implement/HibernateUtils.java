package com.lab3.implement;

import java.util.Properties;

import com.lab3.POJO.Manufacture;
import com.lab3.POJO.Phone;
import com.lab3.implement.ManufactureDaoImpl;
import com.lab3.implement.PhoneDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Settings;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtils {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf=new Configuration();
        conf.configure("hibernate.cfg.xml");
        Properties props =new Properties();
        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,"jdbc:mysql://localhost:3306/PhoneManufacture");
        props.put(Environment.USER,"root");
        props.put(Environment.PASS,"1234");
        props.put(Environment.SHOW_SQL,"true");
        conf.setProperties(props);
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);

        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY =conf.buildSessionFactory(registry);

    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

}
