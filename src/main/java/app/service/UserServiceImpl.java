package app.service;

import app.model.User;
import app.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Override
    public void addUser(String name, String surName, int socialNumber) {
        userDao.addUser(name, surName, socialNumber);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void changeUser(User user) {
        userDao.changeUser(user);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
