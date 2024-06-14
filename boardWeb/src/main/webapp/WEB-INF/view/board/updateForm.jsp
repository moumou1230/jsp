<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<form action = "updateBoard.do">
	<input type="hidden" value = "${board.boardNo }" name="bno">
	<input type="hidden" value = "${page }" name="page">
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">
	<table class = "table">
		<tr>
			<th>글번호</th>
			<td colspan = "3"><input type = "text" name = "bno"  value ="${board.boardNo }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan = "3"><input  type = "text" name = "uTitle"  value ="${board.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan = "3"><textarea name = "uContent" cols="80" rows="3" >${board.content }</textarea></td>
		</tr>
		<tr>
			<td><input class="btn btn-warning" type = "submit" value = "수정완료"></td>
		</tr>
	</table>
</form>
<script>
	
</script>
