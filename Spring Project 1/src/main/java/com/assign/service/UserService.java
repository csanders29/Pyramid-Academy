package com.assign.service;

import com.assign.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int userId);
    void saveOrUpdate(User theUser);
    void deleteById(int userId);
}
