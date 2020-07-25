<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>template</title>
<jsp:include page="/includes/assets.jsp"></jsp:include>
</head>
<body>
	<body class="">
  <div class="wrapper ">
    
    <jsp:include page="/WEB-INF/views/includes/sidebar.jsp"></jsp:include>
    <div class="main-panel">

      <jsp:include page="/WEB-INF/views/includes/topbar.jsp"></jsp:include>
      
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
              list content
            </div>
          </div>
        </div>
      </div>
      
      <jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
      
    </div>
  </div>
  <jsp:include page="/WEB-INF/views/includes/fixed-plugin.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/includes/corejs.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/includes/bottomjs.jsp"></jsp:include>
  
</body>
</body>
</html>