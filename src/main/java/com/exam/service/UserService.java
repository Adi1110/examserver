package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    //creating users
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    // get all the user
    public List<User> getAllUser();

    //delete the user by id
    public void deleteUser(Long id);

    //update the userS

}
