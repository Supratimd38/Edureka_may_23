package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.User;

public class JdbcUserDao implements UserDao {

    private Connection connection;

    public JdbcUserDao(String jdbcUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(jdbc:mysql://localhost:3306/mydb, root,);
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.executeUpdate();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            return new User(id, firstName, lastName, email);
        }
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            users.add(new User
