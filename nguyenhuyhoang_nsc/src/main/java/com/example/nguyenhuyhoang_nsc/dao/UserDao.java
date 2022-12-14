package com.example.nguyenhuyhoang_nsc.dao;

import com.example.nguyenhuyhoang_nsc.model.User;
import com.example.nguyenhuyhoang_nsc.utils.ConnectionUtils;

import java.sql.*;

public class UserDao {
    Connection connection = ConnectionUtils.getConnection();

    public User getUser(String pName, String password) {
        User user = null;
        String sql = "select * from users where username = '"+pName +"' and password = " +password;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                user = new User(name, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

}
