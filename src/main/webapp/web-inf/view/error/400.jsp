<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <title>Bad request</title>
</head>
<body>
<div class="container">
    <h3>Student Directory</h3>
    <hr/>
    <p>You've entered bad data we couldn't process. Please, check data and try again.</p>
    <a href="${pageContext.request.contextPath}/student/list">Back to all students</a>
</div>
</body>
</html>
