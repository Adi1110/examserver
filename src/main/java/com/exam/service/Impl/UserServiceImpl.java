package com.exam.service.Impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userReop;
    @Autowired
    private RoleRepository roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userReop.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User already present in our database!!");
            throw new Exception("User already present");
        }else{
            for(UserRole ur : userRoles){
                roleRepo.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userReop.save(user);
        }
        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userReop.findByUsername(username);
    }

    //get all the user
    @Override
    public List<User> getAllUser() {
        return this.userReop.findAll();
    }

    //delete the user by user id
    @Override
    public void deleteUser(Long id) {

        this.userReop.deleteById(id);
    }
}
