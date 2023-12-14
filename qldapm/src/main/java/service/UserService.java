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
    public boolean checkAccountExist(String email) {
        List<User> list = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT* FROM user")
                    .mapToBean(User.class).collect(Collectors.toList());
        });
        for (User u : list) {
            if (email.equals(u.getEmail())) return true;
        }
        return false;
    }
    public void addUser(String name, String email, String pass) {
        List<User> users = getListUser();
        int count = users.size();
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `user` VALUES ("+(count+1)+", '"+name+"', '"+email+"', '"+pass+"');").execute();

        });

    }

    public static void main(String[] args) {
        System.out.println(getInstance().checkAccountExist("xuanhoa@gmail.com"));
//       getInstance().addUser("ABC", "abc@gmail.com","abc123");
    }


}
