<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>JSP - Hello World</title>
</head>
<body>
    <table class="table table-responsive">
        <thead>
            <tr>
                <td>Book Id</td>
                <td>Name</td>
                <td>Total pages</td>
                <td>Type</td>
                <td>Quantity</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td>
                        <c:out value="${book.Id}"></c:out>
                    </td>
                    <td>
                        <c:out value="${book.Name}"></c:out>
                    </td>
                    <td>
                        <c:out value="${book.TotalPage}"></c:out>
                    </td>
                    <td>
                        <c:out value="${book.Type}"></c:out>
                    </td>
                    <td>
                        <c:out value="${book.Quantity}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>