
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"prefix="fmt" %>
<!--<jsp:include page="../public/header.jsp"/>-->

<form name = "myFrm">
	<input type="hidden" value = "${board.boardNo }" name="bno">
	<input type="hidden" value = "${page }" name="page">
	<input type="hidden" value="${searchCondition }" name = "searchCondition">
	<input type="hidden" value="${keyword }" name = "keyword">
 	<table class="table table-sm">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3">${board.boardNo }</td>
			<!-- 1/12, 3/12크기정도 차지하겠다. -->
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2">${board.clickCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly cols="80" rows="3">${board.content }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.wirter }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }"/></td>
		</tr>
		<tr>
			<td>
				<button type="button"  class="btn btn-warning"
				 onclick="location.href='boardList.do?bno=${board.boardNo }&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }'">뒤로</button>
				 
				 <button type="button" class="btn btn-danger" onclick="remove()">삭제</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function remove(){
		if(confirm("삭제하시겠습니까?")){
			location.href='deleteBoard.do?bno=${board.boardNo}&page=${page};
			alert('삭제완료');
			
		}else{
			alert('삭제실패');
		}			
	}
</script>
<a href="boardList.do?page=${page }&searchCondition=${searchCondition }&keyword=${keyword }">목록으로 이동하기</a>
