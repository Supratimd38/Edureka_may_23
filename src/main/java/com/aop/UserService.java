package com.aop;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public void addUser(User user) {
        // add the user to the database
        System.out.println("Adding user: " + user.getFirstName() + " " + user.getLastName());
    }
    
    public List<User> getUsers() {
        // retrieve the list of users from the database
        List<User> users = new ArrayList<>();
        System.out.println("Retrieving users: " + users);
        return users;
    }
}
