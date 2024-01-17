<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" defer></script>
<title>welcome page</title>
</head>
<body>
	<main>
		<div class="container">
			<h1>Welcome ${name}!</h1>
			<hr>
			<div>
				<a href="list-todos">manage</a> your todos
			</div>
		</div>
	</main>
</body>
</html>