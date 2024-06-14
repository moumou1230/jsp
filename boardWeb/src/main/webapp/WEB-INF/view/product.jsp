<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<jsp:include page="../public/header.jsp"/>

	<h3>Product 페이지</h3>
		
	<table border="2">
		<tr>
			<th>학생번호</th><td>${student.stdNo }</td>
		</tr>
		<tr>
			<th>학생이름</th><td>${student.stdName }</td>
		</tr>
		<tr>
			<th>연락처</th><td>${student.phone }</td>
		</tr>
	</table>
	
	<a href ="main.do">목록보기</a>
<jsp:include page="../public/header.jsp"/>