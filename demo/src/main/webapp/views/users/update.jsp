<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Update JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="username" class="form-label">Username</label>
        <input id="username" type="text" name="username" value="${user.username}" class="form-control"/>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Update</button>
        <a href="/user/list" class="btn btn-danger">Back</a>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
