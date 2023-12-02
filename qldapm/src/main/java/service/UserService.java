package service;

import bean.User;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();

        }
        return instance;
    }

    public boolean checkEmail(String email) {
        List<User> listuser = getListUser();
        for (User u : listuser) {
            if (u.getEmail().equals(email)) return true;

        }
        return false;
    }

    public User login(String e, String pass) {
//        String sql = "SELECT iduser,`name`,`password`,email FROM user WHERE email = :email and password = :pass";
//        User user = JDBIConnector.get().withHandle(handle -> {
//            return handle.createQuery(sql).bind("email", email).mapToBean(User.class).findOne().orElse(null);
//        });
//        return user;
        User user = new User();
        if (!checkEmail(e)) {
            user=null;
        }

        List<User> listuser = getListUser();
        for (User u : listuser) {
            if (u.getEmail().equals(e) && u.getPassword().equals(pass)) {
               return u;
            }
            user = null;

        }
        return user;
    }

    public List<User> getListUser() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM user")
                    .mapToBean(User.class).collect(Collectors.toList());
        });
    }
//    public static void main(String[] args) {
//        System.out.println(getInstance().login());
////        System.out.println(getInstance().getListUser());
//        System.out.println(getInstance().login("ledang200234@gmail.com","123456");
//    }


}
