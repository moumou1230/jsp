<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
	div.reply div{
	margin: auto;
	}
	div.reply ul{
	list-style-type: none;
	margin-top:3px;
	}
	div.reply li {
		padding-top : 1px;
		padding-bottom: 1px;
	}
	div.reply span{
		display: inline-block;
	}
</style>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

a {
	text-decoration-line: none;
}
</style>

<p>${board }</p>

<form name="myFrm">
	<input type="hidden" value="${board.boardNo }" name="bno">
	<input type="hidden" value="${page }" name="page">
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">

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
					onclick="location.href='updateForm.do?bno=${board.boardNo }&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }'">수정</button>
	
					<button type="button" class="btn btn-danger" onclick="remove()">삭제</button>
					
					<button type="button" class="btn btn-danger"
					onclick="location.href = 'deleteForm.do?bno=${board.boardNo }]&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }'">삭제처리</button>
					</c:when>
					
					<c:otherwise>
					<button type="button" disabled class="btn btn-warning"
					onclick="location.href='updateForm.do?bno=${board.boardNo }&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }'">수정</button>
					
					<button type="button" disabled class="btn btn-danger" onclick="remove()">삭제</button>
					
					<button type="button" disabled class="btn btn-danger"
					onclick="location.href = 'deleteForm.do?bno=${board.boardNo }&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }'">삭제처리</button>
					</c:otherwise>
				</c:choose>	
			</td>
		</tr>
	</table>
</form>

<!--  댓글관련 시작 -->
<div class = "container reply">
	<div class = "header">
		<input class = "col-sm-8" id = "reply">
		<button class = "col-sm-3" id = "addReply">등록</button>
	</div>


	<div class ="content">
		<ul>
			<li>
				<span class = "col-sm-1">글번호</span>
				<span class = "col-sm-4">글내용</span>
				<span class = "col-sm-2">작성자</span>
				<span class = "col-sm-3">작성일시</span>
				<span class = "col-sm-1">삭제</span>
			</li>
			<li><hr /></li>
			<li style ="display : none">
				<span class = "col-sm-1">3</span>
				<span class = "col-sm-4">글을 잘봤습니다.</span>
				<span class = "col-sm-2">user01</span>
				<span class = "col-sm-3">2024-05-08 13:22:34</span>
				<span class = "col-sm-1"><button onclick = "deleteRow(event)">삭제</button></span>
			</li>
		</ul>
	</div>
	
	<div class = "footer">
		<div class = "center">
			<div class= "pagination">
				<a href="#">1</a>
				<a href="#" class = "active">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
			</div>
		</div>
	</div>
</div>
<!--  댓글관련 종료 -->
<script>
	const bno = "${board.boardNo }";
	const replyers = "${logId}";
	//document.querySelector('button.btn-warning').addEventListner('click',function(e){
		//삭제화면이동일 경우에는 removeform
		//수정화면 이동일 경우에는 action = "modifyForm.do"
		//document.forms.myFrm.action = "updateFrom.do";
		//document.forms.myFrm.submit();
		
	//})
	function remove(){
		if(confirm("삭제하시겠습니까?")){
			location.href='deleteBoard.do?bno=${board.boardNo }&page=${page }&searchCondition=${searchCondition }&keyword=${keyword }';
			alert('삭제완료');

		} else {
			alert('삭제실패');
		}
	}
</script>
<script src = "js/replyService.js"></script>
<script src = "js/reply.js"></script>
<a href="boardList.do?page=${page }">목록으로 이동하기</a>