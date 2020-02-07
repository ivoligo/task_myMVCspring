<%--
  Created by IntelliJ IDEA.
  User: ivoligo
  Date: 05.02.2020
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
    <table border="2">
        <tr>
            <th>id</th>
            <th>Логин</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Город</th>
            <th>Возраст</th>
            <th>Действие</th>
        </tr>
        <c:forEach items = "${users}" var = "user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.city}</td>
                <td>${user.age}</td>
                <td>
                    <form action="/edit/${user.id}" method="get">
                        <input type="submit" value="изменить">
                    </form>
                    <form action="/delete/${user.id}" method = "get">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action = "/add">
        <input type="submit" value="добавить пользователя">
    </form>
</body>
</html>
