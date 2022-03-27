package com.math.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.math.entity.Prac;
import com.math.entity.User;
import com.math.service.PracServiceImp;
import com.math.service.UserServiceImp;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImp US;
	PracServiceImp PraS;
    public LoginServlet() {
        US=new UserServiceImp();
        PraS = new PracServiceImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		
		System.out.println(name+"  "+password);
		PrintWriter out = response.getWriter();
		
		
		
		
		if(name.equals("")) {
			System.out.println("用户名空");
			out.write("<script>alert('请输入用户名!');history.back();</script>");
		
		}else if(password.equals("")){
			System.out.println("密码空");
			out.write("<script>alert('请输入密码!');history.back();</script>");
			
		}
		
		else {
			User u = US.findUserByLogin(new User(name, password));
			List<Prac> p=null;
	
			if(u!=null) {
				p=PraS.FindPracs();
				request.setAttribute("pracs", p);
				
				
				//登陆成功后，应该把登陆用户名，存进session中
				HttpSession session = request.getSession();
				session.setAttribute("loginName", u.getUsername());
				out.write("<script>alert('登陆成功');location.href='center.jsp';</script>");
//				request.getRequestDispatcher("/center.jsp").forward(request,
//                        response);
			}else {
				out.write("<script>alert('用户名或密码错误!');history.back();</script>");			
			}
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	

}
