<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");//idex.html에서 입력된 값을 담아서 여기에 호출??
		String pw = request.getParameter("passwd");//idex.html에서 입력된 값을 담아서 여기에 호출??
	%>
	
	<p>아이디는 <%=id %></p>
	<p>비밀번호는 <%=pw %></p>
	<a href = "../index.html">첫페이지로 이동</a>
</body>
</html>