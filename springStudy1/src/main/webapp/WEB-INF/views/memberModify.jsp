<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보 수정
	<form method="post" action="/userUpdate">
		<input type="text" name="id" placeholder="아이디 입력해라"><br>
		<input type="password" name="pw" placeholder="비밀번호 입력해라"><br>
		<input type="email" name="email" placeholder="이메일 입력해라"><br>
		<input type="text" name="addr" placeholder="니네 집 어디야"><br>
		<input type="text" name="job" placeholder="뭐하냐?"><br>
		<input type="text" name="like" placeholder="너가 젤 최고로 진짜 엄청 가장좋아는건?"><br>
		<button>정보수정</button>
	</form>
</body>
</html>