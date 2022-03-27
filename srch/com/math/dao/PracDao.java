package com.math.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.math.entity.Prac;

public interface PracDao {
	int addData(Connection conn,Prac p) throws SQLException;
	int GetMaxId(Connection conn)throws SQLException;
	ResultSet FindRec(Connection conn)throws SQLException;
}
