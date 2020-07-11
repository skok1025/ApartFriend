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
					<h2>welcome! first time you visit!</h2>
			</div>

			<!-- Login Form -->
			<form action="${pageContext.servletContext.contextPath}/naverjoin"
				method="post">
				<input type="hidden" name="email" value="${naverprofile.email }">
				<input type="hidden" name="name" value="${naverprofile.name }">
				<input type="hidden" name="gender" value="${naverprofile.gender }">
				<input type="text" id="unitNo" name="unitNo" class="fadeIn second" name="unitNo"
					placeholder='동-호수 (예시:"110-1502")'>  
					<input type="submit"
					class="fadeIn fourth" value="come in">
			</form>

		</div>
	</div>


</body>
</html>