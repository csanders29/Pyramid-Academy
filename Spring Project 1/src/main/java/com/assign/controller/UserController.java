package com.assign.controller;

import com.assign.entity.User;
import com.assign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceIMPL")UserService userService){
        this.userService = userService;
    }

    //This is a GET request that will read a list of all the employees.
    //http://localhost:8080/retrieveAllEmployees
    @GetMapping("/retrieveAllEmployees")
    public List<User> findAll() {
        return userService.findAll();
    }

    //This is a POST request to add a new employee.
    //http://localhost:8080/addEmployee
    @PostMapping("/addEmployee")
    public User addEmployee(@RequestBody User theUser) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theUser.setId(0);

        //This will call the employeeDqoImpl.save method to save a new employee
        //through the employeeService interface SPRING
        userService.saveOrUpdate(theUser);
        return theUser;
    }

    //This is a PUT request to update an existing employee.
    //http://localhost:8080/updateEmployee
    @PutMapping("/updateEmployee")
    public User updateEmployee(@RequestBody User updateUser) {
        //No theEmployee.setId(0); this will execute an update instead of a create
        userService.saveOrUpdate(updateUser);
        return updateUser;
    }

    //This is a DELETE request to delete an existing employee.
    //http://localhost:8080/deleteEmployee/1
    @DeleteMapping("/deleteEmployee/{userId}")
    public String deleteEmployee(@PathVariable int userId) {
        //This will execute the deleteByID.
        userService.deleteById(userId);
        userService.findById(userId);
        return "Deleted employee id : " + userId;
    }

    //http://localhost:8080/getEmployee/2
    @GetMapping("/getEmployee/{userId}")
    public User getUser(@PathVariable int userId) {
        User user = userService.findById(userId);
        return user;
    }

}


