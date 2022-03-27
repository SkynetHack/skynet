package com.math.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;
import com.math.entity.Pro;
import com.math.service.ProService;
import com.math.service.ProServiceImp;


/**
 * Servlet implementation class GetPracs
 */
@WebServlet("/GetPracs")
public class GetPracs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProServiceImp ProS;
	
    public GetPracs() {
    	ProS=new ProServiceImp();
    	// TODO Auto-generated constructor stub
    }
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Pro> p=ProS.CreatePro();
		Gson json = new Gson();
		String res = json.toJson(p);
		response.getWriter().write(res);
		request.setAttribute("Pros", p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
