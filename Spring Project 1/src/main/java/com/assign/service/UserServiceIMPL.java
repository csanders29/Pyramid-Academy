package com.assign.service;

import com.assign.dao.UserDAO;
import com.assign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService{
    private final UserDAO UserDAO;

    @Autowired
    public UserServiceIMPL(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    @Override
    public List<User> findAll() {
        return UserDAO.findAll();
    }

    @Override
    public User findById(int userId) {
        return (User) UserDAO.findById(userId);
    }

    @Override
    public void saveOrUpdate(User theUser) {
        UserDAO.saveOrUpdate(theUser);
    }

    @Override
    public void deleteById(int userId) {
        UserDAO.deleteById(userId);
    }
}
