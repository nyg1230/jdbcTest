<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 폼</title>
</head>
<body>
	<%@include file="../common/header.jsp" %>
	
	<h1>회원 가입 폼</h1>
	<form action="/jdbc1/mInsert.do">
		
		<table>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="userId" id=""></td>
				<td><button type="button" id="dupBtn">아이디 중복 확인</button></td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td><input type="password" name="userPw" id="userPw"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>PW 확인 : </td>
				<td><input type="password" name="userPw2" id="userPw2"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="userName" id=""></td>
				<td></td>
			</tr>
			
			<tr>
				<td>성별 : </td>
				<td><input type="radio" name="gender" id="" value="M">남성</td>
				<td><input type="radio" name="gender" id="" value="F">여성</td>
				<td></td>
			</tr>
			
			<tr>
				<td>나이 : </td>
				<td><input type="number" name="age" id="" min="10" max="100"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Email : </td>
				<td><input type="email" name="email" id=""></td>
				<td></td>
			</tr>
			
			<tr>
				<td>연락처 : </td>
				<td><input type="tel" name="phone"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>주소 : </td>
				<td><input type="text" name="address" id=""></td>
				<td></td>
			</tr>
			
			<tr>
				<td>취미  : </td>
				<td colspan = "2">
					<input type="checkbox" name="hobby" id="" value="자전거">자전거
					&nbsp;&nbsp;
					<input type="checkbox" name="hobby" id="" value="독서">독서
					&nbsp;&nbsp;
					<input type="checkbox" name="hobby" id="" value="산책">산책
					<br>
					<input type="checkbox" name="hobby" id="" value="음악감상">음악감상
					&nbsp;&nbsp;
					<input type="checkbox" name="hobby" id="" value="얼리어답터">얼리어답터
					&nbsp;&nbsp;
					<input type="checkbox" name="hobby" id="" value="인생계획">인생계획
					&nbsp;&nbsp;
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td colspan = "2">
					<input type="submit" value="회원가입">
					&nbsp;&nbsp;
					<input type="reset" value="가입취소">
				</td>
			</tr>
		</table>
	
	</form>
	
	<%@include file="../common/footer.jsp" %>
</body>
</html>