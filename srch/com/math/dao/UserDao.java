package com.math.dao;
import java.sql.*;
import com.math.entity.*;

public interface UserDao {
	ResultSet UserLogin(Connection conn,User U)throws Exception;
	int AddUser(Connection conn,User U)throws Exception;
}
