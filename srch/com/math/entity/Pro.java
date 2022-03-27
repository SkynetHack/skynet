package com.math.entity;

public class Pro {
	private int proid;
	private String content;
	private String result;
	private int score;
	public Pro(int proid, String content, String result, int score) {
		super();
		this.proid = proid;
		this.content = content;
		this.result = result;
		this.score = score;
	}
	
	public Pro(String content, String result, int score) {
		super();
		this.content = content;
		this.result = result;
		this.score = score;
	}

	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Pro [proid=" + proid + ", content=" + content + ", result=" + result + ", score=" + score + "]";
	}
	

}
