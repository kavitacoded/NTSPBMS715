package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.CoronaPatientBO;

public class PatientDAOImpl implements IPatientDAO{

	//HAS-A property
	private DataSource ds;
	//prepare string query
	private static final String  PATIENT_INSERT_QUERY="INSERT INTO CORONA_PATIENT VALUES(PATIENT_SEQ.NEXTVAL,?,?,?)";
	
	int count=0;
	public PatientDAOImpl(DataSource ds) {
	System.out.println("PatientDAOImpl.PatientDAOImpl() 1- param constructor");
		this.ds = ds;
	}//const


	@Override
	public int insert(CoronaPatientBO bo) throws Exception {
	
		try(
			//get pooled connection
				Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(PATIENT_INSERT_QUERY);
				
			){
			//set param values
			if(ps!=null) {
				ps.setString(1, bo.getPname());
				ps.setString(2, bo.getAddr());
				ps.setDouble(3,bo.getTotal());
				
				//execute query
			count=	ps.executeUpdate();
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
