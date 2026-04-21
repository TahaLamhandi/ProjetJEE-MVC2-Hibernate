package dao;

import dao.User;

import java.util.List;

public interface UserDAO {
    User finduser(String email , String password);
    boolean checkifemailexist(String email);
    void save(User user);
    List<User> findallusers();
}
