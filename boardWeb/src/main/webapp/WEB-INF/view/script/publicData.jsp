<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<style>

    #centerList b {
        color: rgb(7, 228, 55);
    }

</style>
<!-- publicData.jsp -->
<h3>공공데이터 연습(publicData).</h3>
<!-- 검색조건 입력하고 목록에서 출력. -->
<select id="searchList" >
</select>



시도 검색:<input type="text" id="search" class="col-sm-6" placeholder="ex)동구 입력">

<button id="findBtn">검색</button>
<button id ="centerDB">센터DB생성</button>

<table class="table">
    <thead>
        <tr>
            <th>센터id</th>
            <th>센터명</th>
            <th>연락처</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody id="centerList"></tbody>
</table>
<script src="js/public.js"></script>