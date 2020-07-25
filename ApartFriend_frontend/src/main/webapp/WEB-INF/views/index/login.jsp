<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<img
					src="https://is5-ssl.mzstatic.com/image/thumb/Purple113/v4/80/b6/6a/80b66a45-d28d-311a-0f4d-acbeee111d80/AppIcon-0-0-1x_U007emarketing-0-0-0-10-0-0-sRGB-0-0-0-GLES2_U002c0-512MB-85-220-0-0.png/246x0w.png"
					id="icon" alt="회사 로고" />
			</div>

			<!-- Login Form -->
			<form action="${pageContext.servletContext.contextPath}/auth"
				method="post">
				<input type="text" id="id" class="fadeIn second" name="id"
					placeholder="userName"> <input type="password"
					id="password" class="fadeIn third" name="password"
					placeholder="password"> <input type="submit"
					class="fadeIn fourth" value="Log In">
			</form>
			<!-- 네이버 로그인 예제 -->
			<div id="naverlogin" style="margin-bottom: 40px;">
				<a href="${naverLoginApiURL}"><img height="50"
					src="${pageContext.servletContext.contextPath }/assets/img/naverlogin.PNG" /></a>
			</div>
			<!-- 네이버 로그인 예제 -->
			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>



</body>
</html>