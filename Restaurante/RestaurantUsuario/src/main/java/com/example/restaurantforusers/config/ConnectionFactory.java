package com.example.restaurantforusers.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection (
                    "jdbc:mysql://localhost:3307/restaurante", "root", "013576");

        } catch (SQLException e){
            throw  new RuntimeException(e);

        }

    }
}
