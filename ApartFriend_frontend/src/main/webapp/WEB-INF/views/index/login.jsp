<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<jsp:include page="/includes/assets.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/assets/css/login.css" />
<script type="text/javascript">
	<c:if test='${param.joinsuccess eq "yes"}'>
	alert("ȸ�����Կ� �����ϼ̽��ϴ�. �ش� ���̵�� �α����� ������ �ּ���.");
	</c:if>
	<c:if test='${param.result eq "fail"}'>
	alert("�α��� �����ϼ̽��ϴ�. ���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���.");
	</c:if>
</script>
</head>
<body>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="ȸ�� �ΰ�" />
			</div>

			<!-- Login Form -->
			<form action="${pageContext.servletContext.contextPath}/auth"
				method="post">
				<input type="text" id="id" class="fadeIn second"  name="id" placeholder="userName"> 
				<input type="text" id="password" class="fadeIn third" name="password" placeholder="password"> 
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>



</body>
</html>