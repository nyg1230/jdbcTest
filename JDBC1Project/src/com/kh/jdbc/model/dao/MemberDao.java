package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.jdbc.model.vo.Member;

// DAO (Data Access Object)
//	service로부터 전달받은 데이터를 실제 DB에 전달하여 CRUD를 실행하는 객체
public class MemberDao {
	
	// 회원 가입을 위한 메소드
	public int insertMember(Member m) {
		
		// 결과 확인을 위한 변수 result
		int result = 0;
		// SQL 쿼리 정보를 담기 위한 Statement
		Statement stmt = null;
		// Connection : DB 연결 정보를 담은 객체
		Connection con = null;

		try {
			// 1. jdbc 드라이버 설정을 위한 Class 등록하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DataBase 연결 객체 생성 / url, userId, userPw
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jsp",
					"jsp"
				);
			
			// 3. 실행하는 sql 구문의 트랜잭션 제어
			// 일반적으로 Connection 객체를 생성할 경우 자동 커밋 설정이 되어 있는데
			// 쿼리가 한 행씩 실행 될 때 마다 자동으 커밋이 발생한다.
			// 따라서 자동 커밋을 직접 제어하기 위해 autoCommit() 메소드를 통해 설정을 변경한다.
			con.setAutoCommit(false);
			
			// 3-1. 연결을 통해 사용하기 위한 쿼리 수행 객체 생성
			stmt = con.createStatement();
			
			// 4. 실행하고자 하는 쿼리 생성
			String sql = "insert into member values ('"
							+ m.getUserId() + "', '"
							+ m.getUserPw() + "', '"
							+ m.getUserName() + "', '"
							+ m.getGender() + "', "
							+ m.getAge() + ", '"
							+ m.getEmail() + "', '"
							+ m.getPhone() + "', '"
							+ m.getAddress() + "', '"
							+ m.getHobby() + "', "
							+ "default"
							+ ")";
//			System.out.println(sql);
			// 5. 작성한 쿼리를 실행시켜 실행 결과를 받기
			// select : ResultSet 객체
			// insert, update, delete : 실행된 행의 개수(정수형)
			result = stmt.executeUpdate(sql);
			
			// 결과가 정상으로 수행되었다면 1
			if(result>0) con.commit();
			else con.rollback();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public Member selectMember(Member m) {
		
		// select의 경우 반환하는 값이 정수형이 아닌 객체이다.
		// 따라서 반환할 객체를 먼저 생성하도록 한다.
		Member result = null;
		
		Connection con = null; // DB connection object
		Statement stmt = null; // 쿼리 수행 객체
		ResultSet rSet = null; // 조회한 결과를 담을 객체
		
		try {
			// 1. jdbc 드라이버 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결을 위한 Connection 객체 생성
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jsp",
					"jsp"
				);
			
			// 3. 연결 객체의 커밋을 직접 통하하기 위해 autoCommit 해제하기
			con.setAutoCommit(false);
			
			// 4. 사용하기 위한 쿼리 수행 객체 생성하기
			stmt = con.createStatement();
			
			// 5. 실행하고자 하는 쿼리 생성하기
			String sql = "select * from member where userid = '" + m.getUserId()
						+ "' and userpw = '" + m.getUserPw() + "'";
			
//			System.out.println(m);
//			System.out.printf("login sql : %s \n", sql);
			
			// 6. 쿼리를 수행하고, 수행한 결과를 ResultSet 객체에 저장하기
			rSet = stmt.executeQuery(sql);
			
			// 7. ResultSet에 담긴 객체를 vo 객체에 기록하기
			// ResultSet은 쿼리 수행의 결과가 참이든 거짓이든 항상 값을 가지고 있다.(어떻게 실행하든 머릿글은 항상 포함하기 때문)
			// 실행한 결과가 있는지 판단하기 위해 rSet.next() 라는 메소드를 활용한다.
			
			if(rSet.next()) {
				result = new Member();
				
				// 이미 존재하는 값을 활용하기
				result.setUserId(m.getUserId());
				result.setUserPw(m.getUserPw());
				
				// ResultSet으로부터 결과 추출하기
				// 1. 결과를 순서대로 받아올 경우 컬럼 기준으로 1, 2, 3 . . . 접근하는 방법
				// 2. 컬럼 명으로 직접 선정하여 받아오는 방법(대소문자 가리지 않음)
				result.setUserName(rSet.getString("username"));
				result.setAge(rSet.getInt("age"));
				result.setGender(rSet.getString("gender"));
				result.setEmail(rSet.getString("email"));
				result.setPhone(rSet.getString("phone"));
				result.setAddress(rSet.getString("address"));
				result.setHobby(rSet.getString("hobby"));
				result.setEnrollDate(rSet.getDate("enrollDate"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 8. DB 연결 후에 사용한 객체들 close하기 선언 시 수행한 순서와 반대로 닫아 주어야 한다.
			try {
				rSet.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updateMember(Member m) {
		
		int result = 0;
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jsp",
					"jsp"
				);
			
			con.setAutoCommit(false);
			stmt = con.createStatement();
			
			String sql = "update member set "
						+ "userpw='" + m.getUserPw() + "', "
						+ "email='" + m.getEmail() + "', "
						+ "age='" + m.getAge() + "', "
						+ "phone='" + m.getPhone() + "', "
						+ "address='" + m.getAddress() + "', "
						+ "hobby='" + m.getHobby() + "' "
						+ "where userid='" + m.getUserId() + "'";
			System.out.printf("upadte sql : %s \n", sql);
			
			result = stmt.executeUpdate(sql);
			
			if(result>0) con.commit();
			else con.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteMember(String userId) {
		int result = 0;
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jsp",
					"jsp"
				);
			System.out.println(12121);
			System.out.println(userId);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = "delete from member where userid='" + userId + "'";
			
			System.out.printf("delete sql : %s \n", sql);
			
			result = stmt.executeUpdate(sql);
			
			if(result>0) con.commit();
			else con.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
