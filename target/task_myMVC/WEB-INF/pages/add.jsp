
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
    <form method="post">
        <input required type="text" name="name" placeholder="Имя">
        <input required type="text" name="surname" placeholder="Фамилия">
        <input required type="email" name="email" placeholder="email, она же логин">
        <input required type="text" name="city" placeholder="город">
        <input required type="number" name="age" placeholder="возраст">
        <input type="submit" value="Сохранить">
    </form>

</body>
</html>
