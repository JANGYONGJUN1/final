<%@page import="java.util.ArrayList"%>
<%@page import="com.yj.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록보기</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script>
		$(function() {
			// 제이쿼리셀렉터.click(동작) ---> 해당 태그(들)에 클릭 이벤트 핸들러를 부착함.
			// '동작' ---> "function() {}"
			// "$(동작);"  ---> "$(function() {});"
			$("td").click(function() {
				// bno 값을 가져옴. (ex.213)
				// $(this) --> 클릭한 td태그
				// $(this).parent() --> tr태그
				// $(this).parent().find(".bno") ---> (.bno 인 td태그)
				let bno = $(this).parent().find(".bno").text();
				
				// 페이지 이동 ---> "Ex11Detail.jsp?bno=213"로 이동.
				// location.href = 새 주소 (문자열); ---> 페이지 이동 (※ 무조건 GET 방식임)
				location.href = "${pageContext.request.contextPath}/board/detail?bno=" + bno;

			});
		});
	</script>
	<style>
		table { border-collapse: collapse; }
		td, th { border: 1px solid grey; padding: 8px; }
		td { cursor: pointer; }
		#next, #prev { text-decoration: none; }
		#pagination { width: 150px; margin-left: 200px; }
	</style>
</head>
<body>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td class="bno">${dto.bno }</td>
				<td>${dto.title}</td>
				<td>${dto.content}</td>
				<td>${dto.writer}</td>
				<td>${dto.writedate}</td>
			</tr>
		</c:forEach>		
	</table>
	<div id="pagination">
		<c:if test="${startNum > 1}"> 
			<a id="prev" href="${pageContext.request.contextPath}/board/list?page=${startNum-5}">&lt;</a>
		</c:if>    
		<c:forEach var="i" begin="${startNum}" end="${endNum}">
			<c:choose>
			<c:when test="${i != pageNum}">
				<a href="${pageContext.request.contextPath}/board/list?page=${i}">${i}</a> 
				</c:when>
				<c:otherwise>
				<span>${i}</span> 
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${lastPageNum > endNum}">
			<a id="next" href="${pageContext.request.contextPath}/board/list?page=${startNum+5}">&gt;</a>
		</c:if>
	</div>
	<button onclick="location.href='${pageContext.request.contextPath}/board/write/form'">글쓰기</button>
	
</body>
</html>