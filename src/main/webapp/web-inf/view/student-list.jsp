<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h3>Student directory</h3>
    <hr/>
    <a href="${pageContext.request.contextPath}/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add
        student</a>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempStudent" items="${students}">
            <c:url var="updateLink" value="/student/showFormForUpdate">
                <c:param name="studentId" value="${tempStudent.id}"/>
            </c:url>
            <tr>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
                <td>
                    <a href="${updateLink}" class="btn btn-info btn-sm">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
