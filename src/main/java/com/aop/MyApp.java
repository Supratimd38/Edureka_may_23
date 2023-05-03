package com.aop;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User("Supratim", "Debnath");
        userService.addUser(user);
        List<User> users = userService.getUsers();
    }
    
}
