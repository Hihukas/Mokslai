package lt.codeacademy.Provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
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
}
