package com.example.csit228f2_2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class MySQLConnection {

    private static String url = "jdbc:mysql://localhost:3306/paquitdb";
    private static String username ="asherpax";
    private static String password = "asher123";
    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("CONNECTED TO DATABASE");

        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        catch (SQLException e){
            e.getMessage();
        }
        return connection;
    }
}