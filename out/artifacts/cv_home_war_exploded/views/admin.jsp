<%@ page import="com.java.astudio.utils.UserType" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/7/2020
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin portal</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron">
        <% String userType = (String) request.getAttribute("user"); %>

        <h3>Welcome to <%=userType%> portal!</h3>


    <form action="adminAction" method="post">
    <div class="form-group col-md-12">
        <label for="dbTable"></label>
        <select class="form-control" name="dbTable" id="dbTable">
            <option value="school">School</option>
            <option value="program">Program</option>
            <option value="specialize">Specialize</option>
        </select>
    </div>

        <div class="form-group col-md-12">
            <label for="name">Name</label>
            <input class="form-control" type="text" name="name" id="name" required>
        </div>


        <div class="form-group col-md-12">
            <input class=" btn btn-primary" type="submit" value="Submit">
        </div>

    </form>
</div>

</body>
</html>
