package com.math.service;

import com.math.dao.UserDaoImp;
import com.math.entity.User;
import com.math.util.DBHelper;


import java.sql.*;


public class UserServiceImp implements UserService{
	private UserDaoImp UD;
	public UserServiceImp() {
		UD = new UserDaoImp();
	}
	@Override
	public User findUserByLogin(User U) {
		Connection connection = DBHelper.getConnection();
		try {
			ResultSet set = UD.UserLogin(connection, U);
			if (set.next()) {
				String username=set.getString("username");
				System.out.println(username);
				String password=set.getString("password");
				return new User(username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			UD.closeALL();
		}
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public int SignUp(User U) throws Exception {
		Connection conn=null;
		int i=0;
		try {
			conn=DBHelper.getConnection();
			i=UD.AddUser(conn, U);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			UD.closeALL();
		}
		return i;
		
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean legalusername(String s) throws Exception {
		if(s.equals("")) {
			System.out.println("�û�������Ϊ��");
			return false;
		}
		// TODO �Զ����ɵķ������
		return true;
	}
	@Override
	public boolean legalpassword(String s) throws Exception {
		
		if(s.equals("")) {
			System.out.println("�û�������Ϊ��");
			return false;
		}
		// TODO �Զ����ɵķ������
		return true;
	}
	
 
}
