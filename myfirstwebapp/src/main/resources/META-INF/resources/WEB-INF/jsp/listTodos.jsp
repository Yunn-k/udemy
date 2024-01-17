<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<!-- script file은 defer조건이 없다면 body태그 끝나기 전에 넣어야 한다 -->
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" defer></script>
<title>todoList</title>
</head>
<body>
	<main>
		<div class="container">
			<h1>here is ${name}'s todo list!</h1>
			<hr>
			<h2>
				<b>Your Todos</b>
			</h2>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
	</main>
</body>
</html>