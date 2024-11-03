<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/write" method="POST">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" /></td>
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