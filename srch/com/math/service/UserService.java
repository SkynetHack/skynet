package com.math.service;

import com.math.entity.*;


public interface UserService {
	
	User findUserByLogin(User U) throws Exception;
	
	int SignUp(User U)throws Exception;
	
	boolean legalusername(String s)throws Exception;
	
	boolean legalpassword(String s)throws Exception;

}
