package com.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.math.entity.Prac;

public class PracDaoImp extends BaseDao implements PracDao{

	@Override
	public int addData(Connection conn, Prac p)throws SQLException {
		String sql="insert into prac (PracId,Score,Date) value (?,?,?)";
		// TODO 自动生成的方法存根
		return super.updateDate(conn, sql, p.getPracid(),p.getScore(),p.getDate());
	}

	@Override
	public int GetMaxId(Connection conn) throws SQLException {
		String sql="select max(PracId) from prac";
		ResultSet set = super.selectDate(conn, sql);
		if(set.next()) {
			return set.getInt(1);
		}
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public ResultSet FindRec(Connection conn) throws SQLException {
		String sql="SELECT * FROM (select * from prac order by PracId desc limit 5) aa ORDER BY PracId";
		// TODO 自动生成的方法存根
		return super.selectDate(conn, sql);
	}
	

}
