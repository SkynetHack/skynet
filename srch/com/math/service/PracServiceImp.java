package com.math.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.math.dao.PracDaoImp;
import com.math.entity.Ans;
import com.math.entity.Prac;
import com.math.entity.Pro;
import com.math.util.DBHelper;

public class PracServiceImp implements PracService{
	
	private PracDaoImp PD;
	
	public PracServiceImp() {
		PD=new PracDaoImp();
	}

	@Override
	public int GetMaxPracId() {
		Connection conn=DBHelper.getConnection();
		try {
			int id = PD.GetMaxId(conn);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int AddPracRec(Prac p) {
		int i=0;
		Connection conn=null;
		try {
			conn = DBHelper.getConnection();
			i=PD.addData(conn, p);
			System.out.println(i);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			// TODO: handle exception
		} finally {
			PD.closeALL();
		}
		// TODO 自动生成的方法存根
		return i;
	}

	@Override
	public boolean Legal(String s) {
		if(s.equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9.-]*");
	    return pattern.matcher(s).matches();
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int Judge(List<Ans> a, List<Pro> p) {
		int i=0,j=0,score=0;
		String[] x=new String[20];
		String[] y=new String[20];
		
		for (Pro pro : p) {
			x[i]=pro.getResult();
			i++;
		}
		for (Ans ans : a) {
			y[j]=ans.getRes();
			j++;
		}
		for(i=0;i<20;i++)
		{
			if(x[i].equals(y[i]))
				score+=5;
		}
		// TODO 自动生成的方法存根
		return score;
	}

	@Override
	public List<Prac> FindPracs() {
		Connection conn=DBHelper.getConnection();
		List<Prac> pracs = new ArrayList<Prac>();
		ResultSet set;
		try {
			set=PD.FindRec(conn);
			while (set.next()) {
				int pracid=set.getInt("PracId");
				int score=set.getInt("Score");
				String date=set.getString("Date");
				pracs.add(new Prac(pracid,score,date));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			PD.closeALL();
		}
		// TODO 自动生成的方法存根
		return pracs;
	}

	
	

	
	
	

}
