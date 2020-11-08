package com.java.astudio.controller;

import com.java.astudio.model.Programs;
import com.java.astudio.model.School;
import com.java.astudio.model.Specialize;
import com.java.astudio.utils.AdminOperations;
import com.java.astudio.utils.CompanyOperations;
import com.java.astudio.utils.UserType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAction", urlPatterns = {"/adminAction"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        submit(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void submit(HttpServletRequest request, HttpServletResponse response){
        String dbTable = request.getParameter("dbTable");
        String name = request.getParameter("name");
        AdminOperations adminOperations = new AdminOperations();
        adminOperations.addItem(dbTable,name);
        request.setAttribute("user", UserType.Admin.name());
        RequestDispatcher rd = request.getRequestDispatcher("views/admin.jsp");
        try {
            rd.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }



}
