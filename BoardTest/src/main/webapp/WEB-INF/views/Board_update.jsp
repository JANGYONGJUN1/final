니나뇨 장용준 씨빠꺼<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/update" method="POST">
	<table>
		<tr>
			<input type="hidden" name="bno" value="${dto.bno }"/>
			<td>제목</td>
			<td><input type="text" name="title" value="${dto.title}"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="${dto.content }"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${dto.writer }"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="작성완료"/>
				<a href="${pageContext.request.contextPath}/board/list"><input type="button" value="목록으로"/></a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>