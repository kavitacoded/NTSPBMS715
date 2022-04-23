package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDao;
import com.nt.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerManagementService {
	//HAs -A property
 private 	ICustomerDao cusdao;
 
	//constructor
	public CustomerMgmtServiceImpl(ICustomerDao dao) {
	this.cusdao = dao;
}


	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {
	
		//calculare principle amount
		Double intramt=(dto.getPamt()*dto.getRate()*dto.getTime())/100;
	
		//prepare customer bo object for persistance data 
		CustomerBO cusBo=new CustomerBO();
		cusBo.setCname(dto.getCname());
		cusBo.setCadd(dto.getCadd());
		cusBo.setPamt(dto.getPamt());
		cusBo.setIntramt(intramt);
		
		//use dao	
		int count=cusdao.insert(cusBo);
		//process the result
		return count ==0? "Registration Failed":"Registration Success ::Interest amount is::"+intramt;

	}//method

}//class
