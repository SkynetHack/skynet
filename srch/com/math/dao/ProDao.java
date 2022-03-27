package com.math.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.math.entity.Pro;

public interface ProDao {
	int DropTable(Connection conn) throws SQLException;
	int AddPro(Connection conn,Pro p) throws SQLException;
	String GetRes(Connection conn,int ProId) throws SQLException;
}
