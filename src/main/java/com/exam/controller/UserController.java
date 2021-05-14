package com.exam.controller;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roleSet = new HashSet<>();

        Role role = new Role();
        role.setRoleId(8L);
        role.setRoleName("USER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roleSet.add(userRole);
        return this.userService.createUser(user,roleSet);
    }

    // get the user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);

    }

    //get all the user
    @GetMapping("/")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    //delete the user by id
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
    }

    //update the the user
}
