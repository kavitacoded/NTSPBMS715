package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerManagementService;
import com.nt.vo.CustomerVO;

public class MainController {
//HAS-A
	 private ICustomerManagementService service;

	public MainController(ICustomerManagementService service) {
		this.service = service;
	}
	
	//process customer
	public String ProcessCustomer(CustomerVO vo)throws Exception{
		//convert VO class obj into DTO class obj
		CustomerDTO cusdto=new CustomerDTO();
		cusdto.setCname(vo.getCname());
		cusdto.setCadd(vo.getCadd());
		cusdto.setPamt(Double.parseDouble( vo.getPamt()));
		cusdto.setRate(Double.parseDouble(vo.getRate()));
		cusdto.setTime(Double.parseDouble(vo.getTime()));
		
		//use service class
		String resultMsg=service.registerCustomer(cusdto);
		
		return resultMsg;
	}//method
	 
}//class
