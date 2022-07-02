package app.dao;

import app.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class UserDaoImplement implements UserDao {
    @PersistenceContext
    private EntityManager manager;

    public UserDaoImplement() {}

    @Override
    public List<User> getListUsers() {
        return manager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(String name, String surName, int socialNumber) {
        addUser(new User(name, surName, socialNumber));
    }

    @Override
    @Transactional
    public void addUser(User user) {
        manager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        manager.remove(getUser(id));
    }

    @Override
    public void changeUser(User user) {
        manager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }
}
