package com.math.entity;

public class Prac {
	private int pracid;
	private int score;
	private String date;
	public Prac(int pracid, int score, String date) {
		super();
		this.pracid = pracid;
		this.score = score;
		this.date = date;
	}
	public Prac(String date) {
		super();
		this.date = date;
	}
	public int getPracid() {
		return pracid;
	}
	public void setPracid(int pracid) {
		this.pracid = pracid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Prac [pracid=" + pracid + ", score=" + score + ", date=" + date + "]";
	}
	
	

}
