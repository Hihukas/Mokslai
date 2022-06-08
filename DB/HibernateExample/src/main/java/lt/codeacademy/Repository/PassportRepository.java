package lt.codeacademy.Repository;

import lt.codeacademy.Entity.Passport;
import lt.codeacademy.Provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassportRepository extends AbstractRepository {

    public List<Passport> getPassport() {

        return getResult(session -> session.createQuery("From Passport", Passport.class).list());
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("From Passport", Passport.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}
