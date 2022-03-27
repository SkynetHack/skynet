package com.math.util;

import java.util.List;

//帮助我们进行分页的工具类
public class Page<T> {
	//这两个属性是我们一开始就应该提供的
	private int currentPage;//当前页
	private int pageSize;//页大小
	
	//这两个属性的数据，来自于数据库
	private int totalRecord;//总页数
	private List<T> list;

	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	//总页数	
	public int getTotalPage() {
		return (totalRecord + pageSize-1)/pageSize;
	}
//上一页
	public int getUpPage() {
		     if(currentPage>1) {
		          return currentPage-1;
		     }
		     return 1;
		}
	
//下一页	
	public int getNextPage() {
		if(currentPage<getTotalPage()) {
		return currentPage+1;
		}
		return 1;
	}
	
	
	
// -----------------------------------	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCureentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
}
