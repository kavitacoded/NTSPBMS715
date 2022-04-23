package com.nt.bo;

public class CustomerBO {

	private Integer id;
	private String cname;
	private String cadd;
	private Double pamt;
	private Double intramt;
	//setter && getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public Double getPamt() {
		return pamt;
	}
	public void setPamt(Double pamt) {
		this.pamt = pamt;
	}
	public Double getIntramt() {
		return intramt;
	}
	public void setIntramt(Double intramt) {
		this.intramt = intramt;
	}
	
}
