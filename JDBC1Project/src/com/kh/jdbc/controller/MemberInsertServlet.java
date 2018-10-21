package com.kh.jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jdbc.model.service.MemberService;
import com.kh.jdbc.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/mInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
//		String[] hobby = request.getParameterValues("hobby");
		String hobby = String.join(", ", request.getParameterValues("hobby"));
		
		// Service 객체를 통한 회원 가입 정보 전달
		MemberService ms = new MemberService();
		Member m = new Member(id, pw, userName, gender, age, email, phone, address, hobby);
		System.out.println("회원 가입 시 전달받을 객체 정보 : " + m);
		
		int result = ms.insertMember(m);
		if(result>0) {
			// 회원가입 성공
			System.out.println("회원가입에 성공하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/loginForm.jsp");
			view.forward(request, response);
		} else {
			// 회원가입 실패
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
