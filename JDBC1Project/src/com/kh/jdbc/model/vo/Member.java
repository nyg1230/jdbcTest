package com.kh.jdbc.model.vo;

import java.sql.Date;

// VO : 데이터 전달용 객체

public class Member implements java.io.Serializable {
	private static final long serialVersionUID = 1000L;
	
	private String userId;	// 아이디
	private String userPw;	// 비밀번호
	private String userName;// 이름
	private String gender;	// 성별
	private int age;		// 나이
	private String email;	// 이메일
	private String phone;	// 연락처
	private String address;	// 주소
	private String hobby;	// 취미
	private Date enrollDate;// 가입일 java.sql.Date
	
	public Member() {}

	public Member(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public Member(String userId, String userPw, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
	}
	
	public Member(String userId, String userPw, String userName, String gender, int age, String email,
			String phone, String address, String hobby, Date enrollDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
