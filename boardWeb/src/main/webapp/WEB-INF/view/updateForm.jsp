<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
	
<%
	SimpleDateFormat sdf = new SimpleDateFormat();
	BoardVO board = (BoardVO) request.getAttribute("board");
	String yyyymmdd = sdf.format(board.getCreationDate());
%>

<form action = "updateBoard.do">
	<table>
		<tr>
			<th>제목</th>
			<td><input type = "text" name = "uTitle"  value ="<%=board.getTitle() %>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type = "text" name = "uContent" value ="<%=board.getContent() %>"></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "수정완료"></td>
		</tr>
	</table>
</form>

<%@include file="../public/footer.jsp"%>