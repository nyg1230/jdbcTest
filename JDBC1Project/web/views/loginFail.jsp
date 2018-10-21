<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 실패 화면!!</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	
	<h1>로그인 실패!!</h1>
	
	<h3 style="color : red;">로그인에 실패하였습니다.</h3>
	<p>
		아이디나 비밀번호를 확인해보시고, <br>
		만약 이상이 없다면 관리자에게 문의하세요!
	</p>
	<br><br><br><br>
	<a href="/jdbc1/index.jsp">처음으로 돌아가기</a>
	
	<%@include file="/views/common/footer.jsp" %>
</body>
</html>