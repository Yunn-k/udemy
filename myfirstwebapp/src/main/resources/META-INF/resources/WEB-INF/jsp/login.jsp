<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" defer></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" defer></script>
<title>Login</title>
</head>
<body>
	<main>
		<div class="container">
			<h1>Login</h1>
			<hr>
			<pre>${errorMsg}</pre>
			<form method="post">
				name: <input type="text" name="name"> password: <input
					type="password" name="pw"> <input type="submit">
			</form>
		</div>
	</main>
</body>
</html>