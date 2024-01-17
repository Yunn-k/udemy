<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<!-- script file은 defer조건이 없다면 body태그 끝나기 전에 넣어야 한다 -->
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" defer></script>
<title>add Todo Details</title>
</head>
<body>
	<main>
		<div class="container">
			<h1>Enter your Todo details!</h1>
			<hr>
			<form:form method="post" modelAttribute="todo">
				<!-- post메서드에서 받을 파라미터 이름과 매칭-->
				Description: <form:input type="text" path="description"
					required="required" />
				<!-- form tag lib를 쓰면서 멤버변수에 path를 맞춰준다-->
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
				<input type="submit" class="btn btn-success" />
			</form:form>
		</div>
	</main>
</body>
</html>