package lt.codeacademy.Repository;

import lt.codeacademy.Entity.Passport;
import lt.codeacademy.Provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassportRepository {
    private final SessionFactory sessionFactory;

    public PassportRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }

    public List<Passport> getPassport() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From Passport", Passport.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
