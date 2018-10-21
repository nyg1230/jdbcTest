<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="com.kh.jdbc.model.vo.*"
%>
<% Member m = (Member)session.getAttribute("m"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JDBC 테스트</title>
</head>
<body>
	<%@include file="views/common/header.jsp" %>
	<h3>
		<a href="views/loginForm.jsp">1. 로그인 폼</a>
	</h3>
	
	<% if(m==null) { %>
	<h3>
		<a href="views/member/memberJoin.jsp">2. 회원가입 폼</a>
	</h3>
	<%} else { %>
	<h3>
		<a href="views/member/memberUpdateForm.jsp">2. 회원정보 수정 폼</a>
	</h3>
	<%} %>
	<%@include file="views/common/footer.jsp" %>
	
</body>
</html>