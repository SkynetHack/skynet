package com.math.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.math.entity.Prac;
import com.math.service.PracServiceImp;

/**
 * Servlet implementation class FindHistory
 */
@WebServlet("/FindHistory")
public class FindHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PracServiceImp PraS;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindHistory() {
    	PraS = new PracServiceImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Prac> p=null;
		p=PraS.FindPracs();
		request.setAttribute("pracs", p);
		PrintWriter out = response.getWriter();
		out.write("<script>alert('前往历史记录');</script>");
		
		request.getRequestDispatcher("/history.jsp").forward(request,
                response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
