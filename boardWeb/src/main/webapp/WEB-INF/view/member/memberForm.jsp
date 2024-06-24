<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원가입</h3>
<form action = "createMember.do" method= "post" enctype ="multipart/form-data">
	<table>
		<tr>
			<th>이름</th><td><input type = "text" name = "name"></td>
		</tr>
		<tr>
			<th>아이디</th><td><input type = "text" name = "id"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type = "password" name = "pw"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input class= "form-cntrol" type = "file" name = "myImage"></td>
		</tr>
		<tr>
			<th><button type = "submit">완료</button></th>
		</tr>
	</table>

</form>