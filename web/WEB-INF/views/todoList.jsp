<%--
  Created by IntelliJ IDEA.
  User: jooeunchung
  Date: 2020/09/11
  Time: 11:05 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<%--<link   rel = "stylesheet" href = "/resources/css/todo.css">--%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/resources/js/todo.js"></script>

<head>
    <title> ** ToDo List **</title>
</head>
<body>

    <div id = "root">

        <div id = "title_div">
            <h1>Todo List</h1>
        </div>

        <div id = "addTodo_div">
            <input type = "text" id = "addTodo_textBox" placeholder="오늘 할일을 계획해보세요!">
            <button type = "button" id = "addTodo_button" onclick="addTodo()">추가</button>
        </div>

        <div id = "todoList_wrap">
            <table>
                <tbody id = "addTodoHere">

                </tbody>
            </table>
        </div>

    </div>

</body>
</html>
