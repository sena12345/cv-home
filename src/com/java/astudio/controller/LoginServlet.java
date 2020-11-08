package com.java.astudio.controller;

import com.java.astudio.model.Admin;
import com.java.astudio.model.Company;
import com.java.astudio.model.School;
import com.java.astudio.model.Student;
import com.java.astudio.utils.AdminOperations;
import com.java.astudio.utils.CompanyOperations;
import com.java.astudio.utils.StudentOperations;
import com.java.astudio.utils.UserType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        login(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        login(request, response);
    }

    private void login(HttpServletRequest request,HttpServletResponse response){
        String user = request.getParameter("login-user");
        System.out.println("User type is :"+user);
        if (user.contentEquals(UserType.Company.name())){
            loginCompany(request,response);}
        if (user.contentEquals(UserType.Admin.name())){
            loginAdmin(request,response);}

        if (user.contentEquals(UserType.Student.name())){
            loginStudent(request, response);}
    }

    private void loginAdmin(HttpServletRequest request,HttpServletResponse response){

           AdminOperations operations = new AdminOperations();
           String email = request.getParameter("login-email");
           String password = request.getParameter("login-password");
           Admin admin = new Admin();
           admin.setEmail(email);
           admin.setPassword(password);
           Admin admin1 =  operations.getAdmin(admin);
           if (admin1 == null || admin1.getEmail().isBlank()){
               RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
               try {
                   rd.forward(request, response);
               } catch (ServletException | IOException e) {
                   e.printStackTrace();
               }
           }else {

               request.setAttribute("user", UserType.Admin.name());
               request.setAttribute("cvs",new CompanyOperations().getAllCvs());
               request.setAttribute("companies",new CompanyOperations().getCompanies());
               RequestDispatcher rd = request.getRequestDispatcher("views/admin.jsp");
               try {
                   rd.forward(request, response);
               } catch (ServletException | IOException e) {
                   e.printStackTrace();
               }

           }

    }

    private void loginCompany(HttpServletRequest request,HttpServletResponse response){
        try {
            CompanyOperations operations = new CompanyOperations();
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");
            Company c = new Company();
            c.setEmail(email);
            c.setPassword(password);
            Company company =  operations.getCompany(c);
            if (company == null || company.getEmail().isBlank() ) {
                System.out.println("is null");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }else {
//                System.out.println(student.getName().toUpperCase());
                request.setAttribute("user", UserType.Company.name());
                request.setAttribute("cvs",operations.getAllCvs());
                RequestDispatcher rd = request.getRequestDispatcher("views/company.jsp");
                rd.forward(request, response);
            }
        }catch (Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException servletException) {
                servletException.printStackTrace();
            }

        }
    }

    private void loginStudent(HttpServletRequest request,HttpServletResponse response){
        try {
            StudentOperations operations = new StudentOperations();
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");
            Student student =  operations.getStudent(email,password);
            if (student == null || student.getEmail().isBlank() ) {
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }else {
//                System.out.println(student.getName().toUpperCase());
                request.setAttribute("user", UserType.Student.name());
                request.setAttribute("student",student);
                request.setAttribute("school",new AdminOperations().getItems("school"));
                request.setAttribute("specialize",new AdminOperations().getItems("specialize"));
                request.setAttribute("program",new AdminOperations().getItems("program"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/student-details.jsp");
                rd.forward(request, response);
            }
        }catch (Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException servletException) {
                servletException.printStackTrace();
            }

        }
    }
}
