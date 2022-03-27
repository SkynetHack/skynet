package com.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.math.entity.Pro;

public class ProDaoImp extends BaseDao implements ProDao{



	@Override
	public int DropTable(Connection conn){
		String sql="truncate table pro";
		// TODO �Զ����ɵķ������
		try {
			return super.updateDate(conn,sql);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int AddPro(Connection conn,Pro p) throws SQLException {
		String sql="insert into pro (proid,content,result,score) values(?,?,?,?)";
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		return null;
	}

	

}
