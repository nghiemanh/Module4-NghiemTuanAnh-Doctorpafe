<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1> Login </h1>
<form action="loginController" method="post">
    <label> Username: </label>
    <input type="text" name="username"> <br>
    <label> Password: </label>
    <input type="password" name="password"> <br>
    <label>&nbsp; </label>
    <input type="submit" value="Login" name="submit">
</form>
</body>
</html>