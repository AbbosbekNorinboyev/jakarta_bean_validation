<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Create JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="name" class="form-label">Full name</label>
        <input id="name" type="text" name="name" class="form-control"/>
    </div>
    <div>
        <label for="age" class="form-label">Age</label>
        <input id="age" type="number" name="age" class="form-control"/>
    </div>
    <div>
        <label for="groupId">Groups</label>
        <select id="groupId" type="button" name="groupId" required>
            <c:forEach items="${groupsList}" var="group">
                <option value="${group.id}">${group.group_name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Save</button>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
