<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Update Student</title>
</head>
<body>
<div class="container">
    <h3>Student Directory</h3>
    <hr/>
    <p class="h4 mb-4">Update Student</p>
    <form:form action="/student/addStudent" modelAttribute="student" method="POST">
        <form:hidden path="id"/>
        <label for="firstName">First Name:</label>
        <form:input path="firstName" class="form-control mb-4 col-4"/>
        <label for="lastName">Last Name:</label>
        <form:input path="lastName" class="form-control mb-4 col-4"/>
        <label for="email">Email</label></td>
        <form:input path="email" class="form-control mb-4 col-4"/>
        <input type="submit" value="Update student" class="btn btn-info col-2"/>
    </form:form>
    <hr>
    <a href="${pageContext.request.contextPath}/student/list">Back to all students</a>
</div>
</body>
</html>
