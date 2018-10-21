<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="com.kh.jdbc.model.vo.*"
%>
<%
	Member m = (Member)session.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 폼</title>
</head>
<body>
	<%@include file="common/header.jsp" %>
	
	<%if(m==null){%>
	<h3>로그인 폼</h3>
	
	<form action="\jdbc1\login.do" method="post">
		<table align="center">
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
		
	</form>
	
	<%} else { %>
	<h3><%=m.getUserName() %>님, 안녕하세요!</h3>
	<p>만약 로그아웃을 하고 싶으시면 여기를 눌러주세요~</p>
	<button type="button" id="logoutBtn" onclick="logout();">로그아웃</button>
	<script>
		function logout(){
			location.href = "/jdbc1/logout.do";
		}
	</script>
	<%} %>
	
	<%@include file="common/footer.jsp" %>
</body>
</html>