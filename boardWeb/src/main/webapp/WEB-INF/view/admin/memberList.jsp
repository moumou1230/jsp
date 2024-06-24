<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- memberList.jsp -->
<h3>회원목록(관리자)</h3>

<ul>
	<c:forEach var = "member" items = "${memberList}">
		<li> id: ${member.userId } ${!empty member.iamge ? '<img width = "200px" src ="images/'+member.image+'>' : ''}>
		</li>
	</c:forEach>
</ul>