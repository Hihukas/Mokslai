package lt.codeacademy.Repository;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lt.codeacademy.Entity.User;
import lt.codeacademy.Provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class UserRepository extends AbstractRepository {

    public void createUser(User user) {

        modifyEntity(session -> session.persist(user));
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//
//            session.persist(user);
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
    }

    public void deleteUser(User user) {
        modifyEntity(session -> session.delete(user));
    }

    public void deleteUserByEmail(String email) {
        modifyEntity(session -> {
            Query query = session.createQuery("delete user where email=:email");
            query.setParameter("email", email);

            query.executeUpdate();
        });

    }

//    public List<User> getUsers() {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("FROM User", User.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }

//    public List<String> getUsersEmails() {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("Select email from User", String.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }

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

//    public void updateUser(User user) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//
//            session.update(user);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }

//    public void updateEmailById(String email, Long id) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//
//            Query query = session.createQuery("update User set email=:email where id=:id");
//            query.setParameter("email", email);
//            query.setParameter("id", id);
//            query.executeUpdate();
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }

//    private void modifyEntity(Consumer<Session> consumer) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//
//            consumer.accept(session);
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
//
//    private <T> T getResult(Function<Session, T> function) {
//        try (Session session = sessionFactory.openSession()) {
//            return function.apply(session);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public List<User> getFilteredUsers() {
        return getResult(session -> {
            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            JpaCriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> root = query.from(User.class);

//            query.select(root); all users
//            query.select(root).where(criteriaBuilder.like(root.get("name"), "Alek%"));
//            query.select(root).where(criteriaBuilder.equal(root.get("id"), 2));

            Predicate equal = criteriaBuilder.equal(root.get("name"), "Aleksandras");
            Predicate like = criteriaBuilder.equal(root.get("surname"), "%ud%");
            Predicate id = criteriaBuilder.equal(root.get("id"), 2);


            query.select(root).where(criteriaBuilder.and(equal, like, id));

            return session.createQuery(query).list();
        });
    }

}
