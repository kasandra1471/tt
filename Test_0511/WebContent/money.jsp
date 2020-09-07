<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<h2>회원매출조회</h2>
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
			<th>고객등급</th>
			<th>매출</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="money" items="${moneyList }">
			<tr style="text-align: center;">
				<td><a href="moneyViewAction.me?id=${money.custno}">
						${money.custno }</a></td>
				<td>${money.custname }</td> 
				<td>${money.grade }</td>
				<td>${money.money }</td>
				
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="footer.jsp"%>


