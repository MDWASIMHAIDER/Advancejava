package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.CustomerBo;

public class CustomerDAo{
	//@Resource(name="Dsjndi")
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO CUSTOMERDETAILS VALUES(?,?,?,?,?)";
	public int insert(CustomerBo bo) {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		int result=0;
		try {
			ic=new InitialContext();
			ds=(DataSource)ic.lookup("Dsjndi");
			//System.out.println("dsjndi after");
			con=ds.getConnection();
			ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
			ps.setInt(1,bo.getSno());
			ps.setString(2,bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setString(4,bo.getResult());
			ps.setFloat(5,bo.getAvg());
			result=ps.executeUpdate();
		}//try close
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			 if(ps!=null) {
				ps.close();
			 }
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		return result;
		}//finally close
	
		
	}//class close


