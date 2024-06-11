<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
	<form action = "addBoard.do">
		<table class = "table">
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "btitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type = "text" name = "bcontent"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type = "text" name = "bwriter"></td>
			</tr>
			<tr>
				<td colspan = "2"><input type = "submit" value = "작성완료"></td>
			</tr>
		</table>
	</form>
<%@include file="../public/footer.jsp"%>