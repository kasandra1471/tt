<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<h2>회원 정보 수정</h2>

<script src="./js/default.js"></script>

<form name="regMem" method="post" 
action="./memberUpdateAction.me"
onsubmit="return checkForm();"
>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<td width="500px">
			<input type="text" size="20" name="custno"
				value=${member.custno } readonly>
			</td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname" size="20"
				value=${member.custname }>
			</td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" size="30"
				value=${member.phone }></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address" size="40"
				value="${member.address }"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="text" name="joindate" size="20"
				value=${member.joindate }></td>
		</tr>
		<tr>
			<th style="padding: 0 20px;">
			고객등급 [A:VIP, B:일반, C:직원]</th>
			<td><input type="text" name="grade" size="20"
				value=${member.grade }></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city" size="20"
				value=${member.city }></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit">수정</button>
			<button type="button">조회</button></td>
		</tr>
	</table>

</form>
<%@ include file="footer.jsp"%>


