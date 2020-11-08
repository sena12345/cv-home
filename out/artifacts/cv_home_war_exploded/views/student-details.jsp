<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.astudio.model.Student" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="com.java.astudio.model.School" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.astudio.model.Specialize" %>
<%@ page import="com.java.astudio.model.Programs" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/7/2020
  Time: 3:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

    <%
        Student student = (Student) request.getAttribute("student");
        String user = (String) request.getAttribute("user");
    %>

    <div class="container">
        <h3>Welcome to <%=user%> portal, <%=student.getName()%></h3>
        <form action="update" method="POST" >
            <h3>Personal details</h3><hr><br>

            <div class="form-group">
                <label for="email">Email</label>
                <input class="form-control" type="email" name="email-update" id="email" required value="<%=student.getEmail()%>"   placeholder= "hello" >

            </div>

            <div>
                <label for="stud-name">Name</label>
                <input class="form-control" type="text" name="stud-name" id="stud-name" required readonly value="<%=student.getName()%>">
            </div>


            <div>
                <label for="stud-address">Address</label>
                <input class="form-control" type="text" name="stud-address" id="stud-address" required readonly value="<%=student.getAddress()%>">
            </div>


            <div>
                <label for="stud-phone">Phone</label>
                <input class="form-control" type="tel" name="stud-phone" id="stud-phone" required readonly value="<%=student.getPhone()%>">
            </div>

            <div>
                <label for="stud-password">Password</label>
                <input class="form-control" type="password" name="stud-password" id="stud-password" required readonly minlength="4" value="<%=student.getPassword()%>">
            </div>

            <h3>Education</h3><hr><br>

            <div>
                <label for="stud-cert">Certificate name</label>
                <input class="form-control" type="text" name="stud-cert" id="stud-cert" required placeholder="Enter certificate" value="<%=student.getCert()%>">
            </div>

            <div>
                <label for="stud-school">School</label>
                <select class="form-control" name="stud-school" id="stud-school">
                    <option selected value="<%=student.getSchool()%>"><%=student.getSchool()%></option>
                    <c:forEach items="${school}" var="spec">
                        <option value="${spec}">${spec}</option>

                    </c:forEach>
                </select>
            </div>

            <div>
                <label for="stud-spec">Specialization</label>
                <select class="form-control" name="stud-spec" id="stud-spec">
                    <option selected value="<%=student.getSpec()%>"><%=student.getSpec()%></option>
                    <c:forEach items="${specialize}" var="spec">
                        <option value="${spec}">${spec}</option>
                    </c:forEach>
                </select>
<%--                <input type="text" name="stud-cert" id="stud-cert" required value="<%=student.getCert()%>">--%>
            </div>


            <div>
                <label for="stud-program">Program</label>
                <select class="form-control" name="stud-program" id="stud-program">
                    <option selected value="<%=student.getProgram()%>"><%=student.getProgram()%></option>
                    <c:forEach items="${program}" var="prog">
                          <option value=${prog}>${prog}</option>
                    </c:forEach>
                </select>
<%--                <input type="text" name="stud-program" id="stud-program" required value="<%=student.getProgram()%>">--%>
            </div>

            <h3>Work Experience</h3><hr><br>

            <div>
                <label for="stud-work">Institutions</label><br>
                <textarea class="form-control" name="stud-work" id="stud-work" cols="30" rows="4" placeholder="Example: Astudio(2019-2020)"><%=student.getWork()%></textarea>
            </div><br><br>


            <div>
                <label for="stud-refs">Referees</label><br>
                <textarea class="form-control" name="stud-refs" id="stud-refs" cols="30" rows="4" placeholder="Example: Elvis Kemevor(emails@gmail.com, 0247417122)"><%=student.getRefs()%></textarea>
            </div>

            <h3>CVs</h3><hr><br>

            <div>
                <label for="stud-cv">Upload cv</label>
                <input class="form-control" type="file"  name="stud-cv" id="stud-cv">
            </div><br>

            <div class="form-group col-md-12">
                <input class="btn btn-sm brn-primary" type="submit" value="Update details">
            </div>

        </form>


    </div>







</body>
</html>
