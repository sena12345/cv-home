package com.java.astudio.controller;

import com.java.astudio.model.Company;
import com.java.astudio.model.Student;
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

@WebServlet(name = "add",urlPatterns = {"/add"})
public class RegisterServlet extends HttpServlet {

    StudentOperations studentOperations = new StudentOperations();
    CompanyOperations companyOperations = new CompanyOperations();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/views/student-details.jsp");
    }



    private void register(HttpServletRequest request,HttpServletResponse response){
        String userType = request.getParameter("register-user");
        if (userType != null){
            if(userType.contentEquals(UserType.Company.name())){
                registerCompany(request,response);
            }
            if(userType.contentEquals(UserType.Student.name())){
                registerStudent(request,response);
            }
        }
    }





    private void registerCompany(HttpServletRequest request,HttpServletResponse response){
        try{
            Company company = new Company();
            company.setEmail(request.getParameter("email"));
            company.setName(request.getParameter("name"));
            company.setPassword(request.getParameter("password"));
            companyOperations.save(company);
            request.setAttribute("user",UserType.Company.name());
            request.setAttribute("cvs",companyOperations.getAllCvs());
            RequestDispatcher rd = request.getRequestDispatcher("/views/company.jsp");
            rd.forward(request, response);

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }




    private void registerStudent(HttpServletRequest request,HttpServletResponse response){
        try {
                Student student = new Student();
                student.setEmail(request.getParameter("email"));
                student.setName(request.getParameter("name"));
                student.setAddress(request.getParameter("address"));
                student.setPhone(request.getParameter("phone"));
                student.setPassword(request.getParameter("password"));
                student.setDob(request.getParameter("dob"));
                studentOperations.save(student);
                request.setAttribute("user",UserType.Student.name());
                request.setAttribute("student",studentOperations.getStudent(request.getParameter("email"),request.getParameter("password")));
                RequestDispatcher rd = request.getRequestDispatcher("/views/student-details.jsp");
                rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
