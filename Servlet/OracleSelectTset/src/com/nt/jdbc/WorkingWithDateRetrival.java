package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class WorkingWithDateRetrival {

	public static void main(String[] args) {
	    String GET_DATE_QUERY="SELECT *FROM WORKING_WITH_DATE";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		SimpleDateFormat sdf=null;
		String name=null,dob=null,doj=null,dom=null;
		int age=0;
		java.sql.Date sqdob=null,sqdom=null,sqdoj=null;
		java.util.Date udob=null,udom=null,udoj=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			if(con!=null)
			ps=con.prepareStatement(GET_DATE_QUERY);
			if(ps!=null)
			rs=ps.executeQuery();
			if(rs!=null)
				while(rs.next()) {
					flag=true;
					name=rs.getString(1);
					age=rs.getInt(2);
					sqdob=rs.getDate(3);
					sqdoj=rs.getDate(4);
					sqdom=rs.getDate(5);
					//convert sql date obj to util date obj
					udob=sqdob;//udob=(java.util.Date)sqdob;
					udoj=sqdoj;
					udom=sqdom;
					//convert util date obj to string obj
					sdf=new SimpleDateFormat("MMM-dd-yyyy");
					dob=sdf.format(udob);
					doj=sdf.format(udoj);
					dom=sdf.format(udom);
					System.out.println(name+" "+age+" "+dob+" "+doj+" "+dom);
					
				}//while
			if(flag==true)
				System.out.println("record found");
			else
				System.out.println("record not found");
		}//try
		catch(SQLException s) {
			s.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}		
		catch(SQLException s) {
			s.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}		
		catch(SQLException s) {
			s.printStackTrace();
		}
		try {
			if(rs!=null)
				rs.close();
		}		
		catch(SQLException s) {
			s.printStackTrace();
		}
		
	}//main

}//class
