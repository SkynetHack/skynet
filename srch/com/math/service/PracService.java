package com.math.service;

import java.util.List;

import com.math.entity.Ans;
import com.math.entity.Prac;
import com.math.entity.Pro;


public interface PracService {
	int GetMaxPracId();
	int AddPracRec(Prac p);
	boolean Legal(String s);
	int Judge(List<Ans> a,List<Pro> p);
	List<Prac> FindPracs();
}
