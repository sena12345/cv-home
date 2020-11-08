package com.java.astudio.controller;

import com.java.astudio.model.Student;
import com.java.astudio.utils.AdminOperations;
import com.java.astudio.utils.StudentOperations;
import com.java.astudio.utils.UserType;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
    StudentOperations operations = new StudentOperations();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("email-update"));
        try {
            Student student = new Student();
            String email = request.getParameter("email-update");
            String password = request.getParameter("stud-password");
            System.out.println(email);
            System.out.println(password);
            student.setSchool(request.getParameter("stud-school"));
            student.setSpec(request.getParameter("stud-spec"));
            student.setCert(request.getParameter("stud-cert"));
            student.setProgram(request.getParameter("stud-program"));
            student.setWork(request.getParameter("stud-work"));
            student.setRefs(request.getParameter("stud-refs"));
            System.out.println(student.getSchool());
            operations.update(email,student);
            Student studentData =  operations.getStudent(email,password);
            request.setAttribute("user", UserType.Student.name());
            request.setAttribute("school",new AdminOperations().getItems("school"));
            request.setAttribute("specialize",new AdminOperations().getItems("specialize"));
            request.setAttribute("program",new AdminOperations().getItems("program"));
            request.setAttribute("student",studentData);
            RequestDispatcher rd = request.getRequestDispatcher("/views/student-details.jsp");
            rd.forward(request, response);


        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }






}
