<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title 캔아이</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
$(function(){
	    $("#delete").click(function(){
	        let bno = ${bno};  // JSP에서 bno 값을 직접 바인딩합니다.
	        console.log("bno 값: " + bno);
	
	        // Ajax 요청
	        $.ajax({
	            url: '${pageContext.request.contextPath}/ajax/delete',
	            data: JSON.stringify({"bno": bno}),  // JSON으로 bno 데이터를 전송
	            type: 'POST',
	            contentType: 'application/json',  // JSON 형식으로 전송
	            dataType: 'json',  // 서버에서 JSON 형식의 응답을 기대
	            success: function(result) {
	                console.log("Ajax 성공, 서버에서 받아온 값: " ); 
	                alert(result.text);
	                location.href="${pageContext.request.contextPath}/board/list";
	            },
	            error: function(xhr, status, error) {
	                console.log("에러 발생:", error);
	                console.log("상태 코드:", status);
	                console.log("응답 내용:", xhr.responseText);
	            }
	        });
	    });
});

</script>
<body>
<table>
	<tr>
		글번호 : <input type="text" name="bno" value="${dto.bno}"/>
	</tr>
	<tr>
		<td>
			제목 : <input type="text" name="title" value="${dto.title}"/>
		</td>
	</tr>
		<td>
			내용 : <textarea>"${dto.content}"</textarea>
		</td>
	<tr>
		<td>
			작성자 : <input type="text" name="writer" value="${dto.writer}"/>
		</td>
	</tr>
	<tr>
		<td>
			작성 날짜 : <input type="text" name="writedate" value="${dto.writedate}"/>
		</td>	
	</tr>
	<tr>
		<td>
			<a id="delete">삭제하기</a>
			<a href="${pageContext.request.contextPath}/board/update/form?bno=${bno}">수정하기</a>
			<a id="list" href="${pageContext.request.contextPath}/board/list">목록으로</a>
		</td>
	</tr>
</table>
</body>
</html>