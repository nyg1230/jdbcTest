<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="com.kh.jdbc.model.vo.*"
%>
<% Member m = (Member)session.getAttribute("m"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보 수정 페이지</title>
<script src="/jdbc1/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@include file="../common/header.jsp" %>
	<h1>회원정보 수정 페이지</h1>
	
	<form id="mUpdate" action="/jdbc1/mUpdate.do" method="post">
		<table>
			<tr>
				<td>ID : </td>
				<td><%=m.getUserId() %></td>
				<td></td>
			</tr>
			
			<tr>
				<td>변경할 PW : </td>
				<td><input type="password" name="userPw" id="userPw"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>변경할 PW 확인 : </td>
				<td><input type="password" name="userPw2" id="userPw2"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" id="result"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><%=m.getUserName() %></td>
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
				<td><input type="number" name="age" id="" min="10" max="100" value="<%=m.getAge()%>"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Email : </td>
				<td><input type="email" name="email" id="" value="<%=m.getEmail()%>"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>연락처 : </td>
				<td><input type="tel" name="phone" value="<%=m.getPhone()%>"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>주소 : </td>
				<td><input type="text" name="address" id="" value="<%=m.getAddress()%>"></td>
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
					<input type="submit" value="회원수정">
					&nbsp;&nbsp;
					<input type="button" onclick="memberDel();" value="회원탈퇴">
				</td>
			</tr>
		</table>
	</form>
	
	<br><br>
	<a href="/jdbc1/index.jsp">처음으로 돌아가기</a>
	<%@include file="../common/footer.jsp" %>
	
	<script>
		// 일반적으로 script 작성 구간은 어디가 되든 큰 문제는 없으나 HTML과 CSS가 웹문서에 로드되는 시점을 고려한다면
		// head영역이나 body의 최하단에 script를 작성하여 로드된 이후, 로드 시점에 동작함으로써
		// 웹 문서 표현의 속도를 높이는 방식을 권장한다.
		
		$(function(){
			// 성별 radio 선택하기
			$('input:radio').each(function(){
				if($(this).val() == '<%=m.getGender()%>') {
					$(this).prop('checked', true);
				} else {
					$(this).prop('checked', false);
				}
				$(this).prop('disabled', true);
			})
			
			// 취미 checkBox 선택하기
			var array = '<%=m.getHobby()%>'.split(', ');
			console.log(array);
			$('input:checkbox').each(function(){
				if($.inArray($(this).val(), array) > -1){
					$(this).prop("checked", true)
				}
			})
			
			// 변경 비밀번호 일치 여부
			$("#mUpdate").submit(function(event){
				if($("#userPw").val() != $("#userPw2").val()){
					// 비밀번호가 일치하지 않을때
					$("#result").text("비밀번호가 일치하지 않습니다.").show().fadeOut(1000);
				} else if ($("userPw").val() == "") {
					// 비밀번호를 입력하지 않았을 때
					$("#result").text("비밀번호를 입력해주세요~").show().fadeOut(1000);
				} else {
					// 정상입력시
					return;
				}
				event.preventDefault();
			})
			
		})
		
		// '회원 탈퇴' 버튼을 누를 경우 mDelete.do로 이동
		function memberDel(){
			location.href = "/jdbc1/mDelete.do"
		}
	</script>
</body>
</html>