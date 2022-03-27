package com.math.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.math.entity.User;
import com.math.service.UserServiceImp;


@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserServiceImp US;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
    	US=new UserServiceImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println(username+"  "+password);
		
		PrintWriter out = response.getWriter();
		
		if(username.equals("")) {
			System.out.println("�û�����");
			out.write("<script>alert('�������û���!');history.back();</script>");
		
		}else if(password.equals("")){
			System.out.println("�����");
			out.write("<script>alert('����������!');history.back();</script>");
			
		}else if(US.findUserByLogin(new User(username, password))!=null)
		{
			out.write("<script>alert('�û��Ѵ���!');history.back();</script>");
		}
		else {
			try {
				US.SignUp(new User(username, password));
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			out.write("<script>alert('ע��ɹ���');location.href='login.html';</script>");
			
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
