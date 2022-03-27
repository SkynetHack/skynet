package com.math.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import com.math.dao.UserDaoImp;
import com.math.entity.Ans;
import com.math.entity.Prac;
import com.math.entity.Pro;
import com.math.entity.User;
import com.math.service.PracServiceImp;
import com.math.service.ProServiceImp;
import com.math.service.UserServiceImp;

public class Process {
	UserDaoImp UD;
	UserServiceImp US;
	ProServiceImp ProS;
	PracServiceImp PraS;
	Scanner sc=new Scanner(System.in);
	
	public Process() {
		UD=new UserDaoImp();
		US=new UserServiceImp();
		ProS=new ProServiceImp();
		PraS=new PracServiceImp();
	}
	public void nextstep() {
		System.out.println("\n按任意键回车返回上级菜单");
		@SuppressWarnings("unused")
		String op4 = input();
		// TODO 自动生成的方法存根

	}
	public String input() {
		byte[] buf = new byte[50];
		try {
			System.in.read(buf);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return new String(buf).trim();
	}
	
	
	
	public void process() throws Exception {
		
		System.out.println("后台测试");
		System.out.println("用户名：");
		String username=input();
		System.out.println("密码：");
		String password=input();
		if(!US.legalusername(username)||!US.legalpassword(password))
		{
			System.out.println("用户名或密码为空");
			System.out.println("用户名：");
			username=input();
			System.out.println("密码：");
			password=input();
		}
			
		User U=US.findUserByLogin(new User(username, password));
		if(U!=null) {
				System.out.println(U);
		}
		System.out.println("登录成功，"+U.getUsername()+"请选择操作：\n1.开始练习\n2.查询最近5次成绩\n3.清空题库");
		
	
		
		String op1 = input();
//-------------------开始练习-----------------
		if(op1.equals("1")) {
			
			
			
			
			int score=0;
			ArrayList<Ans> anser =new ArrayList<Ans>();
			List<Pro> list = ProS.CreatePro();
			for (Pro pro : list) {
				
				System.out.println(pro);
				System.out.println("输入答案：");
				String ans=input();
				while(!PraS.Legal(ans)) {
					System.out.println("答案不合法，重新输入");
					ans=input();
				}
				
				anser.add(new Ans(ans));
				
			}
			
			score=PraS.Judge(anser, list);
			System.out.println(score);
			
			
			Calendar now=Calendar.getInstance();
			String date=now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
			int maxid = PraS.GetMaxPracId();
			Prac prac=new Prac(maxid+1,score,date);
			PraS.AddPracRec(prac);
			
		}else if (op1.equals("2")) {
			
			List<Prac> p = PraS.FindPracs();
			for (Prac prac : p) {
				System.out.println(prac);
			}
		}else if (op1.equals("3")) {
			int i=ProS.DelPro();
			System.out.println(i);
			if(i==0) {
				System.out.println("题库删除成功");
			}else{
				System.out.println("题库删除失败");
			}
		}
		
//		清空临时题目表
//		ProS.DelPro();
		
	}
}
