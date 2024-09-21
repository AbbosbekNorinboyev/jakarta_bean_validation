<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Delete JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div class="alert alert-danger">
        <h1>Are you sure delete this student <i>${student.full_name}</i></h1>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Delete</button>
        <a href="/student/list" class="btn btn-danger">Back</a>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
