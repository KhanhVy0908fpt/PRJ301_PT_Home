<%-- 
    Document   : edit
    Created on : 9 Jun 2025, 11:39:10
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Todo!</h1>
        <form action="edit" method="POST">
            <input type='hidden' name='id' value="${todo.id}"/>
            Title: <input type="text" name="title" required value="${todo.title}"/><br/>
            Status: <input type="checkbox" name="status" value="1" ${todo.status?'checked':''}/>Done<br/>
            <input type="submit" value="Update"  />
        </form>
        <a href="list">Back to list</a>

    </body>
</html>
