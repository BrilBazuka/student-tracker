<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <title>Student list</title>
</head>
<body>
<div class="container">
    <h3>Student directory</h3>
    <hr/>
    <a href="${pageContext.request.contextPath}/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add
        student</a>
    <form:form action="/student/search" method="GET">
        <label for="searchName">Search name:</label>
        <input id="searchName" type="text" name="searchName">
        <input type="submit" value="Search" class="btn btn-primary">
    </form:form>
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
            <c:url var="deleteLink" value="/student/deleteStudent">
                <c:param name="studentId" value="${tempStudent.id}"/>
            </c:url>
            <tr>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
                <td>
                    <a href="${updateLink}" class="btn btn-info btn-sm">Update</a>
                    <a href="${deleteLink}" onclick=" if (!(confirm('Are you sure you want to delete this student?'))) return false"
                       class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${!empty searchName}">
        <a href="${pageContext.request.contextPath}/student/list">Back to all students</a>
    </c:if>
</div>
</body>
</html>
