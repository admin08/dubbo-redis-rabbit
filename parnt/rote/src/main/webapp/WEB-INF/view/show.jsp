<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	

	<form action="/addType" method="post">
		name: <input name="" />

	</form>
	<table>
		<c:forEach items="list" var="obj">
			<tr>
				<td>${obj.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>