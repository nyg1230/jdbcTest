package com.kh.jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.jdbc.model.service.MemberService;
import com.kh.jdbc.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정용 데이터 꺼내오기
		String pw = request.getParameter("userPw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email= request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = String.join(", ", request.getParameterValues("hobby"));
		
		// 해당 회원을 구분짓는 id 받아오기
		HttpSession session = request.getSession(false);
		
		Member m = (Member)session.getAttribute("m");
		
		// 기존의 회원 정보를 새로운 값으롭 변경하기
		m.setUserPw(pw);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		System.out.printf("변경한 회원 정보 확인 : %s \n", m);
		
		MemberService ms = new MemberService();
		
		ms.updateMember(m);
		
		if(ms.updateMember(m)>0) {
			// 회원 정보 수정 성공!
			System.out.println("회원 정보 수정 완료!");
			session.invalidate();
			
			RequestDispatcher view = request.getRequestDispatcher("views/loginForm.jsp");
			
			view.forward(request, response);
		} else {
			// 회원 정보 수정 실패!
			response.sendRedirect("views/common/errorPage.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
