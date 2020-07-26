<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Student list</title>
</head>
<body>
<div class="container">
    <h3>Student list</h3>
    <hr/>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempStudent" items="${students}">
            <tr>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
