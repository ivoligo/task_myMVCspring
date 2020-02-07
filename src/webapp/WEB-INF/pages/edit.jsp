<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение пользователя</title>
</head>
<body>
 <%--   <c:set var="user" value="${user}">
    </c:set>
  --%>  <c:url value="/edit" var="var"/>
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <input required type="text" name="name" value="${user.name}" placeholder="Имя">
        <input required type="text" name="surname" value="${user.surname}" placeholder="Фамилия">
        <input required type="email" name="email"  value="${user.email}" placeholder="email, она же логин">
        <input required type="text" name="city"  value="${user.city}" placeholder="город">
        <input required type="number" name="age"  value="${user.age}" placeholder="возраст">
        <input type="submit" value="применить">
    </form>

</body>
</html>
