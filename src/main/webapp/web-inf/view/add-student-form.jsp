<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">

    <title>Add Student</title>
</head>
<body>
<div class="container">
    <h3>Student Directory</h3>
    <hr/>
    <p class="h4 mb-4">Add Student</p>
    <form:form action="/student/addStudent" modelAttribute="student" method="POST">
        <p class="mb-1"><label for="firstName">First Name:</label></p>
        <form:input path="firstName" placeholder="First name" class="form-control mb-2 col-4"/>
        <form:errors path="firstName" cssClass="error"/>
        <p class="mb-1"><label for="lastName">Last Name:</label></p>
        <form:input path="lastName" placeholder="First name" class="form-control mb-2 col-4"/>
        <form:errors path="lastName" cssClass="error"/>
        <p class="mb-1"><label for="email">Email</label></p>
        <form:input path="email" placeholder="First name" class="form-control mb-2 col-4"/>
        <form:errors path="email" cssClass="error"/>
        <br>
        <input type="submit" value="Save" class="btn btn-info col-2"/>
    </form:form>
    <hr>
    <a href="${pageContext.request.contextPath}/student/list">Back to all students</a>
</div>
</body>
</html>
