<%@page import="co.yedam.web.BoardList"%>
<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- "boardList"에 담긴 값을 읽어서 반복처리 -->
<%@include file="../public/header.jsp"%>
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
a{
  text-decoration-line: none;
}
</style>
<!--  
	//request는 jsp의 내장객체
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
	PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
%>-->


<h3>게시글 목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<!--for (BoardVO vo : list)  --> 
		<c:forEach var = "vo" items = "${boardList }">
		<tr>
			<!--  <td>%=vo.getBoardNo() %></td>
			<td><a href = "getBoard.do?bno=%=vo.getBoardNo()%>&page=%=pageDTO.getPage()%>">%=vo.getTitle() %></a></td>
			<td>%=vo.getWriter() %></td>
			<td>%=vo.getClickCnt() %></td>-->
			<td>${vo.boardNo }</td>
			<td><a href = "getBoard.do?bno=${vo.boardNo }&page=${paging.page}">${vo.title }</a></td>
			<td><c:out value="${vo.writer }"/> </td>
			<td><c:out value="${vo.clickCnt }"/></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan = "2"><input type = "button" value = "작성" onclick = "location.href = 'boardForm.do'"></td>
		</tr>
	</tbody>
</table>
<!-- paging -->
<div class="center">
  <div class="pagination">
  
  <!--if(pageDTO.isPrev())-->
  <c:if test="${paging.prev }">
  <a href="boardList.do?page=${paging.startPage-1 }">&laquo;</a>
  </c:if>
  
  <!--for(int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++){ %>
  %	if(p == pageDTO.getPage()){ %>
  <a href="boardList.do?page=%=p %>" class = "active">%=p %></a>
  %	} else{ %>
  <a href="boardList.do?page=%=p %>">%=p %></a>
  %} }%>-->
  
  <c:forEach var= "p" begin="${paging.startPage }" end="${paging.endPage }">
  	<c:choose>
  		<c:when test="${p == paging.page }">
  			<a href="boardList.do?page=${p }" class = "active"><c:out value="${p }"/></a>
  		</c:when>
  		<c:otherwise>
  			<a href="boardList.do?page=${p }"><c:out value="${p }"/> </a>
  		</c:otherwise>
  	</c:choose> 
  </c:forEach>
  
  <!--if (pageDTO.isNext())-->
  <c:if test="${paging.next }">
  <a href="boardList.do?page=${paging.endPage+1 }">&raquo;</a>
  </c:if>

  </div>
</div>
<%@include file="../public/footer.jsp"%>