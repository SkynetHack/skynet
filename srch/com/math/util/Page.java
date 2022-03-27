package com.math.util;

import java.util.List;

//�������ǽ��з�ҳ�Ĺ�����
public class Page<T> {
	//����������������һ��ʼ��Ӧ���ṩ��
	private int currentPage;//��ǰҳ
	private int pageSize;//ҳ��С
	
	//���������Ե����ݣ����������ݿ�
	private int totalRecord;//��ҳ��
	private List<T> list;

	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	//��ҳ��	
	public int getTotalPage() {
		return (totalRecord + pageSize-1)/pageSize;
	}
//��һҳ
	public int getUpPage() {
		     if(currentPage>1) {
		          return currentPage-1;
		     }
		     return 1;
		}
	
//��һҳ	
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
