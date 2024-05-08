package com.example.csit228f2_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/f2paquit_javadb";
    private static final String USERNAME = "asherpax";
    private static final String PASSWORD = "pax123";



    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connected to the database!");


        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }

}