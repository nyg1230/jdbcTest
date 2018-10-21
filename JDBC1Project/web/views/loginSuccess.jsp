<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="com.kh.jdbc.model.vo.*"
%>
<%
	// 로그인 서블릿을 통해 접속한 사용자 정보 꺼내오기
	Member m = (Member)session.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 성공 화면</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	
	<h1>로그인 성공</h1>
	<h3><%=m.getUserName() %>님 환영합니다!!</h3>
	<p>
		회원정보 : <%= m.toString() %>
	</p>
	<a href="index.jsp">처음으로 가기</a>
	<%@include file="/views/common/footer.jsp" %>
</body>
</html>