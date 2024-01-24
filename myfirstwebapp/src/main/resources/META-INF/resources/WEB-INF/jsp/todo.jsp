<!-- header include -->
<%@ include file="common/header.jspf"%>

<main>
	<!-- navigation include -->
	<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Enter your Todo details!</h1>
		<hr>
		<!-- post메서드에서 받을 파라미터 이름과 매칭-->
		<form:form method="post" modelAttribute="todo">

			<!-- label, input, errors가 모두 하나의 필드인 description에 연계되어 있음. 따라서 fieldset 사용 -->
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<!-- form tag lib를 쓰면서 멤버변수에 path를 맞춰준다-->
			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input type="submit" class="btn btn-success" />

		</form:form>
	</div>
</main>

<!-- footer include -->
<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd', <!--start date는 이미 객체 자체에 초기화 설정을 해놓았으므로 여기에서는 필요X-->
		}); 
</script>





