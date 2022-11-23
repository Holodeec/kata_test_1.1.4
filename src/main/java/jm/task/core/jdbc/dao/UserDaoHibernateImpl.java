package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE if not exists users(id int primary key auto_increment," +
                    "name varchar(20) not null ,lastName varchar(20) not null ," +
                    "age int)").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Еху!!!");
        } catch (RuntimeException e) {
            System.out.println("ФакОф...");
        }

    }

    @Override
    public void dropUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Еху!!!");
        } catch (RuntimeException e) {
            System.out.println("ФакОф...");
        }



    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = Util.getSessionFactory().openSession()) {
            User user = new User(name,lastName,age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User с именем " + name + " добавлен в базу данных.");
        } catch (RuntimeException e) {
            System.out.println("Страдай еще...");
        }
    }

    @Override
    public void removeUserById(long id) {
        try(Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete User where id="+id).executeUpdate();
            session.getTransaction().commit();
            System.out.println("User с id " + id +" удален.");

        } catch (RuntimeException e) {
            System.out.println("ФакОф...");
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        try(Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            list = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
            System.out.println("Еху!!!");
        } catch (RuntimeException e) {
            System.out.println("ФакОф...");
            //dsdsds
        }

        return list;
    }

    @Override
    public void cleanUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Таблица users очищена");
        } catch (RuntimeException e) {
            System.out.println("ФакОф...");
        }
    }
}
