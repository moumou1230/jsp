<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../public/header.jsp" />

<p>${board }</p>

<form name="myFrm">
	<input type="hidden" value="${board.boardNo }" name="bno">
	<table class="table table-sm">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3"><c:out value="${board.boardNo }" /></td>
			<!-- 1/12, 3/12크기정도 차지하겠다. -->
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2"><c:out value="${board.clickCnt }"></c:out></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><c:out value="${board.title }" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly cols="80" rows="3"><c:out value="${board.content }" /></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><c:out value="${board.writer }" /></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }" />
			</td>
		</tr>	
		<tr align="center">
			<td colspan="3" >
				<c:choose>
					<c:when test="${!empty logId && logId == board.writer }">
					<button type="button" class="btn btn-warning"
					onclick="location.href='updateForm.do?bno=${board.boardNo }&page=${page }'">수정</button>
	
					<button type="button" class="btn btn-danger" onclick="remove()">삭제</button>
					
					<button type="button" class="btn btn-danger"
					onclick="location.href = 'deleteForm.do?bno=${board.boardNo }]&page=${page }'">삭제처리</button>
					</c:when>
					
					<c:otherwise>
					<button type="button" disabled class="btn btn-warning"
					onclick="location.href='updateForm.do?bno=${board.boardNo }&page=${page }'">수정</button>
					
					<button type="button" disabled class="btn btn-danger" onclick="remove()">삭제</button>
					
					<button type="button" disabled class="btn btn-danger"
					onclick="location.href = 'deleteForm.do?bno=${board.boardNo }&page=${page }'">삭제처리</button>
					</c:otherwise>
				</c:choose>	
			</td>
		</tr>
	</table>
</form>
<script>
	//document.querySelector('button.btn-warning').addEventListner('click',function(e){
		//삭제화면이동일 경우에는 removeform
		//수정화면 이동일 경우에는 action = "modifyForm.do"
		//document.forms.myFrm.action = "updateFrom.do";
		//document.forms.myFrm.submit();
		
	//})
	function remove(){
		if(confirm("삭제하시겠습니까?")){
			location.href='deleteBoard.do?bno=${board.boardNo }&page=${page }';
			alert('삭제완료');

		} else {
			alert('삭제실패');
		}
	}
</script>
<a href="boardList.do?page=${page }">목록으로 이동하기</a>
<jsp:include page="../public/footer.jsp" />