<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<jsp:include page="/includes/assets.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/assets/css/login.css" />
<script type="text/javascript">
	<c:if test='${param.joinsuccess eq "yes"}'>
	alert("회원가입에 성공하셨습니다. 해당 아이디로 로그인을 진행해 주세요.");
	</c:if>
	<c:if test='${param.result eq "fail"}'>
	alert("로그인 실패하셨습니다. 아이디 혹은 비밀번호를 확인해주세요.");
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
					alt="회사 로고" />
			</div>

			<!-- Login Form -->
			<form action="${pageContext.servletContext.contextPath}/auth"
				method="post">
				<input type="text" id="id" class="fadeIn second"  name="id" placeholder="userName"> 
				<input type="password" id="password" class="fadeIn third" name="password" placeholder="password"> 
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