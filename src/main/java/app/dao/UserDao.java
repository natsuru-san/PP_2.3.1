package app.dao;

import app.model.User;
import java.util.List;

public interface UserDao {
    List<User> getListUsers();
    void addUser(String name, String surName, int socialNumber);
    void addUser(User user);
    void deleteUser(long id);
    void changeUser(User user);
    User getUser(long id);
}
