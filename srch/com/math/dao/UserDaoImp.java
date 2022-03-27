package com.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.math.entity.User;

public class UserDaoImp extends BaseDao implements UserDao{

	@Override
	public ResultSet UserLogin(Connection conn, User U) throws SQLException {
		String sql="select * from user where username=? and password=?";
		// TODO 自动生成的方法存根
		return super.selectDate(conn,sql,U.getUsername(),U.getPassword());
		
	}

	@Override
	public int AddUser(Connection conn, User U) throws Exception {
		String sql="insert into user (username,password) value (?,?)";
		return super.updateDate(conn, sql, U.getUsername(),U.getPassword());
		// TODO 自动生成的方法存根
		
	}

	
	

}
