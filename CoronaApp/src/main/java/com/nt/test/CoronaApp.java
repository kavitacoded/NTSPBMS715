package com.nt.test;


import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


import com.nt.controller.MainController;
import com.nt.vo.CoronaPatientVO;

public class CoronaApp {

	public static void main(String[] args) {
		String name=null,addr=null,noofdays=null,perdaycharge=null;
		
		//read input
		Scanner sc=new Scanner(System.in);
		if(sc!=null) {
			System.out.println("Enter Patient  name");
			name=sc.next();
			
			System.out.println("Enter patien address");
			addr=sc.next();
			
			System.out.println("Enter no of days");
			noofdays=sc.next();
			
			System.out.println("Enter perday charge");
			perdaycharge=sc.next();
		}//if
		
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		
		//controller class object
		MainController controller=factory.getBean("controller",MainController.class);
		
		//create vo class object having those input
		
		CoronaPatientVO vo=new CoronaPatientVO();
		vo.setPname(name);
		vo.setAddr(addr);
		vo.setNoofdays(noofdays);
		vo.setPerdaycharge(perdaycharge);
		
		
		//invoke b method
		try {
		String msg=controller.ProcessPatient(vo);
		System.out.println(msg);
		}//try
		catch(Exception e) {
			System.out.println("problem register patient");
			e.printStackTrace();
		}
		
	}//main
}//class
