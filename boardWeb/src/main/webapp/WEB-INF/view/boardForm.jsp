<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../public/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<form action = "addBoard.do">
		<table class = "table">
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "btitle"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name = "bwriter" value = "${logId }" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea  name = "bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan = "2"><input type = "submit" value = "작성완료"></td>
			</tr>
		</table>
	</form>
<jsp:include page="../public/footer.jsp"/>