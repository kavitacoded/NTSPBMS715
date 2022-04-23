package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements ICustomerDao {
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO REALTIMEDI_CUSTOMER VALUES(CUST_NO_SEQ.NEXTVAL,?,?,?,?)";

//HAS-A property
	private DataSource ds;
	public CustomerDAOImpl(DataSource ds) {
		System.out.println("CustomerDAOImpl.CustomerDAOImpl() o- param constructor"+CustomerDAOImpl.class);
		this.ds=ds;
		
	}
	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("CustomerDAOImpl.insert()");
		int count=0;	
		//get pooled jdbc connection object
	try(	Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
			){
		//set values to query param by collecting the data from BO class object
		if(ps!=null) {
			ps.setString(1,bo.getCname() );
			ps.setString(2, bo.getCadd());
			ps.setDouble(3, bo.getPamt());
			ps.setDouble(4, bo.getIntramt());
			
			//execute query
			count=ps.executeUpdate();
		}//if
		
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	
		return count;
	}//method

}//class
