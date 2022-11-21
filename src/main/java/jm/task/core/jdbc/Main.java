package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

//        UserDao userDao = new UserDaoJDBCImpl();

        UserDao userDao1 = new UserDaoHibernateImpl();
//        userDao1.saveUser("Alex","Djordon",(byte) 33);
//        userDao1.saveUser("Vertro","Getso",(byte) 23);
//        userDao1.saveUser("РАБОТАЙ","ПОЖАЛУСТА",(byte) 43);
        userDao1.dropUsersTable();
        System.out.println(userDao1.getAllUsers());


    }
}
