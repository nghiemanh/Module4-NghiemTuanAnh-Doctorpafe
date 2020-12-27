<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Doctor Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%
    String username = (String).session.getAttribute("tendangnhap");
    if (session != null) {
        System.out.println("Hello" + username);
    } else {
        System.out.println("Hello");
    }
%>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="https://www.admin.net" class="navbar-brand"> Doctor
                Management Application </a>
        </div>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Doctor</h3>
        <hr>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Nationality</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Education</th>
                <th>Position</th>
                <th>Specialized</th>
                <th>Hospital</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="doctor" items="${listDoctor}">

                <tr>
                    <td><c:out value="${doctor.id}"/></td>
                    <td><c:out value="${doctor.name}"/></td>
                    <td><c:out value="${doctor.Gender}"/></td>
                    <td><c:out value="${doctor.Nationality}"/></td>
                    <td><c:out value="${doctor.Address}"/></td>
                    <td><c:out value="${doctor.Phone}"/></td>
                    <td><c:out value="${doctor.Education}"/></td>
                    <td><c:out value="${doctor.Position}"/></td>
                    <td><c:out value="${doctor.Specialized}"/></td>
                    <td><c:out value="${doctor.Hospital}"/></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>