package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerManagementService {

	public String registerCustomer(CustomerDTO dto)throws Exception;
}
