package com.nt.beans;

public class StudentBeans {
	private String sname;
	private int sno;
	private String savg;
	private String sadd;
	public StudentBeans() {
		System.out.println("student bean 0-param constructor");
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSavg() {
		return savg;
	}
	public void setSavg(String savg) {
		this.savg = savg;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

}
