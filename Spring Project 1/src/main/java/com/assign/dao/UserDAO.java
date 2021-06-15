package com.assign.dao;

import com.assign.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    Object findById(int theId);
    void saveOrUpdate(User theUser);
    void deleteById(int theId);


}
