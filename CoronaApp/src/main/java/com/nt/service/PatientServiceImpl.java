package com.nt.service;

import com.nt.bo.CoronaPatientBO;
import com.nt.dao.IPatientDAO;
import com.nt.dto.CoronaPatientDTO;

public class PatientServiceImpl implements PatientService {

	//HAS-A property
	private IPatientDAO dao;
	public PatientServiceImpl(IPatientDAO dao) {
		System.out.println("PatientServiceImpl.PatientServiceImpl() 1- param constructor");
		this.dao = dao;
	}
	@Override
	public String patientregister(CoronaPatientDTO dto) throws Exception {
	//calculate total bill amount
		Double total=dto.getNoofdays()*dto.getPerdaycharge();
		
		//create object of bo class obj persistance obj
		
		CoronaPatientBO pbo=new CoronaPatientBO();
		pbo.setPname(dto.getPname());
		pbo.setAddr(dto.getAddr());
		pbo.setTotal(total);
		
		//use 
		int count=dao.insert(pbo);
		return count == 0? "Register fail":"success"+"Total bill anount::"+ total;
	}

}
