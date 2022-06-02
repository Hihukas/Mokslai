package lt.codeacademy.Repository;

import lt.codeacademy.Entity.User;
import lt.codeacademy.Provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserRepository {
    private final SessionFactory sessionFactory;

    public UserRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }

    public void createUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
