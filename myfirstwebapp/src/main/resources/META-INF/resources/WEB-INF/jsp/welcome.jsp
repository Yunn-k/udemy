<!-- header include -->
<%@ include file="common/header.jspf"%>

<main>
	<!-- navigation include -->
	<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Welcome ${name}!</h1>
		<hr>
		<div>
			<a href="list-todos">manage</a> your todos
		</div>
	</div>
</main>

<!-- footer include -->
<%@ include file="common/footer.jspf"%>