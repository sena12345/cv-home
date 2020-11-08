package com.java.astudio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
    final static String username = "gzMX4idXW2";
    final static String database ="gzMX4idXW2";
    final static String password = "W2VjJqdKsV";
    final static String server = "remotemysql.com";
    final static String port ="3306";
    private static Connection  con = null;

    public static void connected(){
        try{
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection(
                        "jdbc:mysql://"+server+":3306/"+database, username,password);

            }

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Connection getCon() {
        if (con == null)
            connected();
        return con;
    }

    public static void disConnect(){
        if (con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}




