package com.math.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;
import com.math.entity.Prac;
import com.math.service.PracServiceImp;

/**
 * Servlet implementation class GetScore
 */
@WebServlet("/GetScore")
public class GetScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
     PracServiceImp PraS;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetScore() {
        PraS=new PracServiceImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String score=request.getParameter("score");
		int Score=Integer.parseInt(score);
		System.out.println("前端传入分数："+score);
		
		Calendar now=Calendar.getInstance();
		String date=now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
		int maxid = PraS.GetMaxPracId();
		Prac prac=new Prac(maxid+1,Score,date);
		PraS.AddPracRec(prac);
		
		Gson json = new Gson();
		String res = json.toJson("cfdafc");
		response.getWriter().write(res);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
