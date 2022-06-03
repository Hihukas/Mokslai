package lt.codeacademy.Provider;

import lt.codeacademy.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private final SessionFactory sessionFactory;


    private SessionFactoryProvider(){
        //Naudojamas tik tada, kai nuskaitomas hibernate.cfg.xml failas
//        sessionFactory = new Configuration().configure().buildSessionFactory();

        Configuration configuration = new Configuration();
        configuration.setProperties(createHibernateProperties());

        //Mapping all entities
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance(){
        if(instance == null){
            instance = new SessionFactoryProvider();
        }

        return instance;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    private Properties createHibernateProperties(){
        Properties properties = new Properties();

        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost/hibernate");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        return properties;
    }
}
