package com.nt.dto;

public class CoronaPatientDTO {

	private Integer pid;
	private String pname;
	private String addr;
	private Double  noofdays;
	private Double perdaycharge;
	
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(Double noofdays) {
		this.noofdays = noofdays;
	}
	public Double getPerdaycharge() {
		return perdaycharge;
	}
	public void setPerdaycharge(Double perdaycharge) {
		this.perdaycharge = perdaycharge;
	}
	
}
