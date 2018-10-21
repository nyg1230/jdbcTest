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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		
		Member m = new Member(id, pw);
		
		MemberService ms = new MemberService();
		
		m = ms.selectMember(m);
		
		if(m != null) {
			// 로그인 성공
			System.out.printf("login 성공 시 결과 : %s", m);
			
			RequestDispatcher view = request.getRequestDispatcher("views/loginSuccess.jsp");
			
			// 로그인 정보 유지하기
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
			view.forward(request, response);
		} else {
			// 로그인 실패
			response.sendRedirect("views/loginFail.jsp");
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
