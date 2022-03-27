package com.math.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.math.dao.ProDaoImp;
import com.math.entity.Pro;
import com.math.util.DBHelper;

public class ProServiceImp implements ProService{
	private ProDaoImp ProD;

	public ProServiceImp() {
		ProD=new ProDaoImp();
	}
	@Override
	public List<Pro> CreatePro() {
		ArrayList<Pro> list=new ArrayList<Pro>();
		String Pro = null;
		Double result = null;
		String resultS = null;
		int score=5;
		for(int i = 0;i < 20;i++)
		{
			
			double firNum = (int)(1 + Math.random()*99);//锟斤拷锟斤拷1锟斤拷99锟斤拷锟斤拷锟斤拷锟�
			double secNum = (int)(1 + Math.random()*99);
			double tirNum = (int)(1 + Math.random()*99);
			int operaNum1 = 1 + (int)(Math.random()*4);//锟斤拷1锟斤拷4锟街憋拷锟斤拷锟接硷拷锟剿筹拷
			int operaNum2 = 1 + (int)(Math.random()*4);
			if(operaNum1 == 1 && operaNum2 == 1)
			{
				result=firNum+secNum+tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"+"+String.format("%.0f",secNum)+ "+" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 1 && operaNum2 == 2)
			{
				result=firNum+secNum-tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"+"+String.format("%.0f",secNum)+ "-" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 1 && operaNum2 == 3)
			{
				result=firNum+secNum*tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"+"+String.format("%.0f",secNum)+ "*" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 1 && operaNum2 == 4)
			{
				if(tirNum==0) {
					
					result=firNum+tirNum/secNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"+"+String.format("%.0f",tirNum)+ "/" + String.format("%.0f", secNum) +"=";
				}
				else {
					
					result=firNum+secNum/tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"+"+String.format("%.0f",secNum)+ "/" + String.format("%.0f", tirNum) +"=";
				}
			}
			if(operaNum1 == 2 && operaNum2 == 1)
			{
				result=firNum-secNum+tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"-"+String.format("%.0f",secNum)+ "+" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 2 && operaNum2 == 2)
			{
				result=firNum-secNum-tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"-"+String.format("%.0f",secNum)+ "-" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 2 && operaNum2 == 3)
			{
				result=firNum-secNum*tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"-"+String.format("%.0f",secNum)+ "*" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 2 && operaNum2 == 4)
			{
				if(tirNum==0) {
					
					result=firNum-tirNum/secNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"-"+String.format("%.0f",tirNum)+ "/" + String.format("%.0f", secNum) +"=";
				}
				else {
					
					result=firNum-secNum/tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"-"+String.format("%.0f",secNum)+ "/" + String.format("%.0f", tirNum) +"=";
				}
			}
			
			if(operaNum1 == 3 && operaNum2 == 1)
			{
				result=firNum*secNum+tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"*"+String.format("%.0f",secNum)+ "+" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 3 && operaNum2 == 2)
			{
				result=firNum*secNum-tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"*"+String.format("%.0f",secNum)+ "-" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 3 && operaNum2 == 3)
			{
				result=firNum*secNum*tirNum;
				resultS=String.format("%.0f",result);
				Pro=String.format("%.0f",firNum)+"*"+String.format("%.0f",secNum)+ "*" + String.format("%.0f", tirNum) +"=";
			}
			if(operaNum1 == 3 && operaNum2 == 4)
			{
				if(tirNum==0) {
					
					result=firNum*tirNum/secNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"*"+String.format("%.0f",tirNum)+ "/" + String.format("%.0f", secNum) +"=";
				}
				else {
					
					result=firNum*secNum/tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"*"+String.format("%.0f",secNum)+ "/" + String.format("%.0f", tirNum) +"=";
				}
			}
			if(operaNum1 == 4 && operaNum2 == 1)
			{
				if(secNum==0) {
					
					result=secNum/firNum+tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",secNum)+"/"+String.format("%.0f",firNum)+ "+" + String.format("%.0f", tirNum) +"=";
				}
				else {
					
					result=firNum/secNum+tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"/"+String.format("%.0f",secNum)+ "+" + String.format("%.0f", tirNum) +"=";
				}
			}
			if(operaNum1 == 4 && operaNum2 == 2)
			{
				if(secNum==0) {
					
					result=secNum/firNum-tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",secNum)+"/"+String.format("%.0f",firNum)+ "-" + String.format("%.0f", tirNum) +"=";
				}
				else {
					
					result=firNum/secNum-tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",secNum)+"/"+String.format("%.0f",firNum)+ "-" + String.format("%.0f", tirNum) +"=";
				}
			}
			if(operaNum1 == 4 && operaNum2 == 3)
			{
				if(secNum==0) {
					
					result=secNum/firNum*tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",secNum)+"/"+String.format("%.0f",firNum)+ "*" + String.format("%.0f", tirNum) +"=";
				}
				else {
					
					result=firNum/secNum*tirNum;
					resultS=String.format("%.2f",result);
					Pro=String.format("%.0f",firNum)+"/"+String.format("%.0f",secNum)+ "*" + String.format("%.0f", tirNum) +"=";
				}
			}
			if(operaNum1 == 4 && operaNum2 == 4)
			{
				
					if(firNum==0)
					{
						if(secNum==0||tirNum==0)
						{
							i--;
							continue;
						}
						else
						{
							result=(double)0;
							resultS=String.format("%.2f",result);
							Pro=String.format("%.0f",firNum)+"/"+String.format("%.0f",secNum)+ "/" + String.format("%.0f", tirNum) +"=";
							
						}
					}else {
						if(secNum==0||tirNum==0)
						{
							i--;
							continue;
						}
						else
						{
							result=firNum/secNum/tirNum;
							resultS=String.format("%.2f",result);
							Pro=String.format("%.0f",firNum)+"/"+String.format("%.0f",secNum)+ "/" + String.format("%.0f", tirNum) +"=";
							
						}
					}
						
						
					
				
			}
			
			
			
			

			
			Pro p=new Pro(Pro, resultS, score);
			
			list.add(p);
			InsertPro(p);
		}
		return list;
	}

	@Override
	public int DelPro() {
		Connection conn=null;
		int i=0;
		try {
			conn=DBHelper.getConnection();
			i=ProD.DropTable(conn);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return i;
	}
	@Override
	public int InsertPro(Pro p) {
		Connection conn = null;
		try {
			conn=DBHelper.getConnection();
			ProD.AddPro(conn, p);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			// TODO: handle exception
		}finally {
			ProD.closeALL();
		}
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		return 0;
	}
	public String GetAns(int proid) {
		Connection conn =null;
		try {
			conn=DBHelper.getConnection();
			return ProD.GetRes(conn, proid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		return null;
	}
	
	
}
