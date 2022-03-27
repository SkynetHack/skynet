package com.math.service;
import java.util.List;
import com.math.entity.Pro;
public interface ProService {
	List<Pro> CreatePro();
	int DelPro();
	int InsertPro(Pro p);
	String GetAns(int proid);

}
