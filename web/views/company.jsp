<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.java.astudio.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/7/2020
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company portal</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

    <%
//        List<Student> students = (List<Student>) request.getAttribute("cvs");
        String user  = (String) request.getAttribute("user");
    %>

    <h3>Welcome to <%=user%> portal</h3>

<div class="container table-responsive">
            <table class="table">
                <thead>
                        <th>Name</th>
                        <th>Email</th>
                        <th>School</th>
                        <th>Program</th>
                        <th>Specialization</th>
                        <th>Qualification</th>
                        <th>Experience</th>
                        <th>Request</th>
                </thead>

                <tbody>
                    <c:forEach items="${cvs}" var="stud">
                        <tr>
                            <td>${stud.getName()}</td>
                            <td>${stud.getEmail()}</td>
                            <td>${stud.getSchool()}</td>
                            <td>${stud.getProgram()}</td>
                            <td>${stud.getSpec()}</td>
                            <td>${stud.getCert()}</td>
                            <td>${stud.getWork()}</td>
                            <td> <a href="mailto:/${stud.getEmail()}">Request CV</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

</div>

</body>
</html>
