package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dao.User;

public interface UserDao {
    
    public void addUser(User user) throws SQLException;
    
    public User getUserById(int id) throws SQLException;
    
    public List<User> getUsers() throws SQLException;
    
    public void updateUser(User user) throws SQLException;
    
    public void deleteUser(int id) throws SQLException;
    
    public void close() throws SQLException;
    
}
