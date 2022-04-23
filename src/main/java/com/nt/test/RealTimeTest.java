package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeTest 
{
    public static void main( String[] args )
    {
    	//create IOC container
    	
    	DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
    	XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
    	reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
    	
    	
    	//get controller class object
    	MainController controller=factory.getBean("controller",MainController.class);
    	
    	//read input from user
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter customer name");
    	String name=sc.next();
    	
    	System.out.println("Enter Customer address");
    	String addrs=sc.next();
      
    	
    	System.out.println("Enter principal");
    	String pamt=sc.next();
    	
    	System.out.println("Enter Rate OF Interest");
    	String rate=sc.next();
    	
    	
    	System.out.println("Enter time");
    	String time=sc.next();
    	
    	//create VO class object having those input
    	
    	CustomerVO vo=new CustomerVO();
    	vo.setCname(name);
    	vo.setCadd(addrs);
    	vo.setPamt(pamt);
    	vo.setRate(rate);
    	vo.setTime(time);
    	
    	
    	//invoke b.method
    	try {
			String msg=controller.ProcessCustomer(vo);
			System.out.println("Result is "+msg);
		} catch (Exception e) {
		System.out.println("problem in customer reg");
		e.printStackTrace();
		}//catch
    }	//method
    }//class




