<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    </thead>
    <tbody>
    <c:forEach items="${listOfBooks}" var="listOfBooks">
        <tr>
            <td><c:out value="${listOfBooks.isbn}"/></td>
            <td><c:out value="${listOfBooks.title}"/></td>
            <td><c:out value="${listOfBooks.author}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

