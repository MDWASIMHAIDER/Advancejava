package com.nt.bo;

public class CustomerBo{
	int sno;
	String sname;
	int total;
	float avg;
	String result;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public void setResult(String result) {
		this.result=result;
	}
	public String getResult() {
		return result;
	}

}
