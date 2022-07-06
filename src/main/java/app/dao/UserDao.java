package app.dao;

import app.model.User;
import java.util.List;

public interface UserDao {
    List<User> pullListUsers();
    void putUser(String name, String surName, int socialNumber);
    void putUser(User user);
    void removeUser(long id);
    void updateUser(User user);
    User pullUser(long id);
}
