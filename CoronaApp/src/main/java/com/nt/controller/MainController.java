package com.nt.controller;



import com.nt.dto.CoronaPatientDTO;
import com.nt.service.PatientService;
import com.nt.vo.CoronaPatientVO;

public class MainController {

	//has a 
	private PatientService service;

	public MainController(PatientService service) {
		System.out.println("MainController.MainController() 1- param constructor");
		this.service = service;
	}
	
	//process customer
	public String ProcessPatient(CoronaPatientVO vo)throws Exception{
		//convert vo class obj to dto
		CoronaPatientDTO dto=new CoronaPatientDTO();
		dto.setPname(vo.getPname());
		dto.setAddr(vo.getAddr());
		dto.setPerdaycharge(Double.parseDouble(vo.getNoofdays()));
		dto.setNoofdays(Double.parseDouble(vo.getNoofdays()));
		
		String rmsg=service.patientregister(dto);
		return rmsg;
	}
}
