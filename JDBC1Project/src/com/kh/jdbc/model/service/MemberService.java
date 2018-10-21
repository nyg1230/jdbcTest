package com.kh.jdbc.model.service;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

// Service
//	Controller인 서블릿에서 전달하는 정보를 비즈니스 로직에 따라 가공하여
//	DAO에게 전달하는 역할을 맞는 객체
public class MemberService {
	// 회원 가입을 위한 메소드
	// 참이면 해당 결과에 대한 행의 개수 : 1행이 삽입되었습니다.
	// 에러가 발생하면 -1 을 반환
	public int insertMember(Member m) {
		
		MemberDao mDao = new MemberDao();
		
		return mDao.insertMember(m);
	}
	
	public Member selectMember(Member m) {
		
		MemberDao  mDao = new MemberDao();
		
		return mDao.selectMember(m);
	}

	public int updateMember(Member m) {
		
		MemberDao mDao = new MemberDao();
		
		return mDao.updateMember(m);
		
	}

	public int deleteMember(String userId) {
		
		MemberDao mDao = new MemberDao();
		
		return mDao.deleteMember(userId);
	}
}
