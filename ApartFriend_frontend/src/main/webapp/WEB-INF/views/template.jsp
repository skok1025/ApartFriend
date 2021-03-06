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
	<div class="container">
		<h2>button</h2>
		<!-- Standard button -->
		<button type="button" class="btn btn-default">Default</button>

		<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
		<button type="button" class="btn btn-primary">Primary</button>

		<!-- Indicates a successful or positive action -->
		<button type="button" class="btn btn-success">Success</button>

		<!-- Contextual button for informational alert messages -->
		<button type="button" class="btn btn-info">Info</button>

		<!-- Indicates caution should be taken with this action -->
		<button type="button" class="btn btn-warning">Warning</button>

		<!-- Indicates a dangerous or potentially negative action -->
		<button type="button" class="btn btn-danger">Danger</button>

		<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
		<button type="button" class="btn btn-link">Link</button>
	</div>
	<div class="container">
		<h2>table</h2>
		<table class="table table-striped">
			<tr>
				<th>head1</th>
				<th>head2</th>
			</tr>
			<tr>
				<td>value1</td>
				<td>value2</td>
			</tr>
		</table>
	</div>
</body>
</html>