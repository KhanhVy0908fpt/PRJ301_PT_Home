<%-- 
    Document   : list
    Created on : May 26, 2025, 10:46:20 PM
    Author     : hiepn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo List</title>
    </head>
    <body>
        <h1>Todo List</h1>
        <a href="add">Add new Todo</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="todo" items="${list}">
                    <tr>
                        <td>${todo.title}</td>
                        <td>${todo.status ? "Done" : "Doing"}</td>
                        <td>
                            <a href="edit?id=${todo.id}">Edit</a>
                            <a href="delete?id=${todo.id}">Delete</a>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
