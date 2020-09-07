<%@ page language="java" 
contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<h2>회원목록 조회/수정</h2>
<table border="1">
	<colgroup>
		<col width="10%">
		<col width="10%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
		<col width="10%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th>회원번호</th>
			<!-- 컬럼의 타이틀 -->
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${memberList }">
			<tr style="text-align: center;">
				<td>
				<a href="memberViewAction.me?id=${member.custno}">
				${member.custno }</a></td>
				<td>${member.custname }</td>
				<td>${member.phone }</td>
				<td>${member.address }</td>
				<td>${member.joindate }</td>
				<td>${member.grade }</td>
				<td>${member.city }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="footer.jsp"%>


