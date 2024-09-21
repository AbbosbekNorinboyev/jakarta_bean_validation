<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Created at</th>
                        <th scope="col">Group(id)</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentList}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.full_name}</td>
                            <td>${student.age}</td>
                            <td>${student.created_at}</td>
                            <td>${student.groups.id}</td>
                            <td>
                                <a href="/delete/student/${student.id}" class="btn btn-danger">Delete</a>
                                <a href="/update/student/${student.id}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
