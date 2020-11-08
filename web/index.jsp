<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/7/2020
  Time: 3:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Register student.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  </head>
  <body>

  <div class="jumbotron">
        <h3>Welcome to CV portals</h3>

        <form action="login" method="post">
          <p> <h5>Login</h5> </p>
          <div class="form-row">

          <div class="form-group col-md-2">
            <label for="login-user">USER TYPE</label>
            <select class="form-control" name="login-user" id="login-user">
              <option value="Admin">Admin</option>
              <option value="Company">Company</option>
              <option value="Student">Student</option>
            </select>
          </div>

          <div class="form-group col-md-4">
            <label for="login-email">Email</label>
            <input class="form-control" type="email" name="login-email" id="login-email" required>
          </div>

          <div class="form-group col-md-4">
            <label for="login-password">Password</label>
            <input class="form-control" type="password" name="login-password" id="login-password" required minlength="4">
          </div>

            <div class="col-md-2">
              <input class="btn btn-sm btn-primary" type="submit" value="Submit" style="margin-top: 2rem;">
            </div>

          </div>



        </form>


  </div>


  <div class="container ">

      <form action="add" method="post">
        <p> <h5>Register</h5> </p><hr>
        <div class="form-row">
        <div class="form-group col-md-4">
        <label for="register-user">USER TYPE</label>
        <select class="form-control" name="register-user" id="register-user">
          <option value="Company">Company</option>
          <option value="Student">Student</option>
        </select>

        </div>
        <div class="form-group col-md-4">
          <label for="name">Name</label>
          <input class="form-control" type="text" name="name" id="name" required minlength="2">

        </div>


        <div class="form-group col-md-4">
          <label for="email">Email</label>
          <input class="form-control" type="email" name="email" id="email" required>

        </div>

        <div class="form-group col-md-4">
          <label for="address">Address</label>
          <input class="form-control" type="text" name="address" id="address" required>

        </div>

        <div class="form-group col-md-4">
          <label for="phone">Phone</label>
          <input class="form-control" type="tel" name="phone" id="phone">

        </div>

        <div class="form-group col-md-4">
          <label for="dob">Dob</label>
          <input class="form-control" type="text" name="dob" id="dob" required>

        </div>

        <div class="form-group col-md-4">
          <label for="password">Password</label>
          <input class="form-control" type="password" name="password" id="password" required minlength="4">

        </div>
        <div class="form-group col-md-4">
          <input style="margin-top: 2rem" class="btn btn-sm btn-primary" type="submit" value="Submit">
        </div>


        </div>
      </form>

  </div>

  </body>
</html>
