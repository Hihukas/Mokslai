package lt.codeacademy.Repository;

import lt.codeacademy.Entity.User;
import lt.codeacademy.Provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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

    public List<User> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<String> getUsersEmails() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("Select email from User", String.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public User getUserById(Long id) {
        return getResult(session -> session.get(User.class, id));
//        try(Session session = sessionFactory.openSession()){
//            return session.get(User.class, id);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return null;
    }

    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateEmailById(String email, Long id){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query query = session.createQuery("update User set email=:email where id=:id");
            query.setParameter("email", email);
            query.setParameter("id", id);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private <T> T getResult(Function<Session, T> function) {
        try (Session session = sessionFactory.openSession()) {
            return function.apply(session);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
