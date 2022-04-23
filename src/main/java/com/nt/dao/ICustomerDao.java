package com.nt.dao;

import com.nt.bo.CustomerBO;

public interface ICustomerDao {
	
	public int insert(CustomerBO bo)throws Exception;
	
}
