package com.java.astudio.utils;

import com.java.astudio.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminOperations {
    PreparedStatement preparedStatement = null;
    ResultSet rs;

    public Admin getAdmin(Admin admin){
        Admin admins = new Admin();
        Connection con = MyDbConnection.getCon();
        String query = "select * from admins where email=? and password=?";
        try{

            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,admin.getEmail());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                admins.setEmail(rs.getString("email"));
                admins.setName(rs.getString("name"));
                admins.setPassword(rs.getString("password"));
            }

            return  admins;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public void addItem(String table,String name){
        String query = "insert into  "+table+" (name) values (?)";
        Connection con = MyDbConnection.getCon();

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<String> getItems(String tableName){
        List<String> values = new ArrayList<>();
        String query = "select * from "+tableName+" ";
        Connection con = MyDbConnection.getCon();

        try {
            preparedStatement = con.prepareStatement(query);

            rs = preparedStatement.executeQuery();

            while (rs.next()){
                values.add(rs.getString("name"));
            }
            return  values;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
