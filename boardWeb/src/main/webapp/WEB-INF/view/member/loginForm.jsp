<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>



<h3>로그인 화면</h3>
<myTag:line/>

<c:set var = "name" value = "hong"></c:set> <!-- 변수값 담을떄 -->
<c:out value = "${name == 'hong' ? '맞다' : '아니다' }"></c:out><!-- 변수 출력할 때 -->

<c:forEach var= "i" begin="1" end = "10" step= "1">
<p>${i }</p>
</c:forEach><!-- for -->

<!-- jsp standard tag library -->
<form action = "login.do">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>


