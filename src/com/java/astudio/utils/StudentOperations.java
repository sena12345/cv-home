package com.java.astudio.utils;



import com.java.astudio.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentOperations {
    PreparedStatement preparedStatement = null;
    ResultSet rs;
    public boolean save(Student student){

        try {
            Connection con = MyDbConnection.getCon();
            String query = "insert into students(name,email,phone,address,password,dob) values (?,?,?,?,?,?)";
            preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getPhone());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPassword());
            preparedStatement.setString(6,student.getDob());
            preparedStatement.executeUpdate();
            System.out.println("done");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        }

    }

    public boolean update(String email,Student student){
        System.out.println(email);
        Connection con = MyDbConnection.getCon();
        String query = "update students set cert = ?, school = ?, specialize = ?, program = ?, work = ?, refs = ?, cv=? where email = ? ";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,student.getCert());
            preparedStatement.setString(2,student.getSchool());
            preparedStatement.setString(3,student.getSpec());
            preparedStatement.setString(4,student.getProgram());
            preparedStatement.setString(5,student.getWork());
            preparedStatement.setString(6,student.getRefs());
            preparedStatement.setBlob(7,student.getCv());

            preparedStatement.setString(8,email);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean delete(String email){
        Connection con = MyDbConnection.getCon();
        String query = "delete from students where email=?";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public Student getStudent(String email,String password){
        Student student = new Student();
        Connection con = MyDbConnection.getCon();
        String query = "select * from students  where  email = ? and  password = ?";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();
            while (rs.next()){

                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
                student.setDob(rs.getString("dob"));
                student.setSchool(rs.getString("school"));
                student.setSpec(rs.getString("specialize"));
                student.setCert(rs.getString("cert"));
                student.setProgram(rs.getString("program"));
                student.setWork(rs.getString("work"));
                student.setRefs(rs.getString("refs"));
            }

            return student;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }
    }

}
