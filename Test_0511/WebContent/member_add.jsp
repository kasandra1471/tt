<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<h2>홈쇼핑 회원 등록</h2>
<script src="./js/default.js"></script>
<form name="regMem" method="post"
 onsubmit="return checkForm();"
	action="./memberJoinAction.me">
	<input type="hidden" name="action" value="insert">
	<table border="1">
		<tr>
			<th>회원번호(자동발생)</th>
			<td width="500px"><input type="text" size="20" name="custno"
				value=${custno } readonly></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname" size="20"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" size="30"></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address" size="40"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="date" name="joindate" size="20"></td>
		</tr>
		<tr>
			<th style="padding: 0 20px;">고객등급 [A:VIP, B:일반, C:직원]</th>
			<td><input type="text" name="grade" size="20"></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city" size="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit">등록</button>
			<button type="button">조회</button></td>
		</tr>
	</table>
</form>
<%@ include file="footer.jsp"%>