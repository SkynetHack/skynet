package com.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.math.entity.Pro;

public class ProDaoImp extends BaseDao implements ProDao{



	@Override
	public int DropTable(Connection conn){
		String sql="truncate table pro";
		// TODO 自动生成的方法存根
		try {
			return super.updateDate(conn,sql);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int AddPro(Connection conn,Pro p) throws SQLException {
		String sql="insert into pro (proid,content,result,score) values(?,?,?,?)";
		// TODO 自动生成的方法存根
		return super.updateDate(conn, sql, p.getProid(),p.getContent(),p.getResult(),p.getScore());
	}

	@Override
	public String GetRes(Connection conn, int ProId) throws SQLException {
		String sql="select result from pro where proid = ?";
		ResultSet set=super.selectDate(conn, sql);
		if(set.next())
		{
			return set.getString(1);
		}
		// TODO 自动生成的方法存根
		return null;
	}

	

}
