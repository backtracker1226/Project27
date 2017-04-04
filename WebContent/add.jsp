<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>add.jsp 입니다. 하이?</h1>

	<!-- 자바코드로 불러 내기 -->
	<%
		String v1 = request.getParameter("v1");
		String v2 = request.getParameter("v1");
		
		Object obj = application.getAttribute("util");
	%>
	
	<%=obj %>
	<!-- el문을 사용해서 불러 내기 -->
	<!-- applicationContext 예제 -->
	<h2>${util.getInt(param.v1, 0) + util.getInt(param.v2, 0)}</h2>

</body>
</html>