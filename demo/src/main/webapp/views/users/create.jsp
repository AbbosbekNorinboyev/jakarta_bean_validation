<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User create JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="username" class="form-label">Username</label>
        <input id="username" type="text" name="username" class="form-control"/>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Save</button>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
