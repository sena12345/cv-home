package com.java.astudio.utils;

import com.java.astudio.model.Company;
import com.java.astudio.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyOperations {
   private PreparedStatement preparedStatement = null;
   private ResultSet rs = null;
    public boolean save(Company company){
        try {
            Connection con = MyDbConnection.getCon();
            String query = "insert into company values (?,?,?)";
            preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1,company.getName());
            preparedStatement.setString(2,company.getEmail());;
            preparedStatement.setString(3,company.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("done");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        }
    }

    public Company getCompany(Company company){
        try{
            Connection con = MyDbConnection.getCon();
            String query = "select email,name,password from company where email=? and password=?";
            this.preparedStatement = con.prepareStatement(query);
            this.preparedStatement.setString(1,company.getEmail());
            this.preparedStatement.setString(2,company.getPassword());
            this.rs = this.preparedStatement.executeQuery();
            Company c = null;
            while (this.rs.next()){
                c = new Company();
                c.setEmail(this.rs.getString("email"));
                c.setName(this.rs.getString("name"));
                c.setPassword(this.rs.getString("password"));
                System.out.println(c.getName());
            }

//            System.out.println(c.getName());

            return  c;
        }catch (Exception e){
           e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }

    public List<Company> getCompanies(){

        try
        {
            List<Company> companies = new ArrayList<>();
            Connection con = MyDbConnection.getCon();
            String query = "select * from company where email=? and password=?";
            preparedStatement = con.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Company company = new Company();
                company.setEmail(rs.getString("email"));
                company.setName(rs.getString("name"));
                company.setPassword(rs.getString("password"));
                companies.add(company);
            }

            return  companies;

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }


    public List<Student> getAllCvs(){
       List<Student> students = new ArrayList<>();
        Connection con = MyDbConnection.getCon();
        String query = "select * from students";
        try {
            preparedStatement = con.prepareStatement(query);

            rs = preparedStatement.executeQuery();
            Student student;
            while (rs.next()){
                student = new Student();
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
                student.setDob(rs.getString("dob"));
                student.setSchool(rs.getString("school"));
                student.setCert(rs.getString("cert"));
                student.setSpec(rs.getString("specialize"));
                student.setProgram(rs.getString("program"));
                student.setWork(rs.getString("work"));
                student.setRefs(rs.getString("refs"));
                students.add(student);
            }

            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }
    }


}
